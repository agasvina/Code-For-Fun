package uk.ac.standrews.cs5031;

import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class JMockTwitterMonitor {
    
    
    @Rule
    public JUnitRuleMockery context = null;
    private TwitterMonitorV2 tm2 = null;
    //Twitter Monitor version 2
    private ListOfTweets tweets  = null;
    private ListOfUsers users = null;
    private ListOfHashtag hashtags = null;
    private ListOfTwitterDate dates = null;
    private log mockLogger = null;


    public JMockTwitterMonitor() {
        this.context = new JUnitRuleMockery() {{
            setImposteriser(ClassImposteriser.INSTANCE);
        }};
    }
    
    
    @Before
    public void setup() {
        this.tweets = context.mock(ListOfTweets.class);
        this.users = context.mock(ListOfUsers.class);
        this.hashtags = context.mock(ListOfHashtag.class);
        this.dates = context.mock(ListOfTwitterDate.class);
        this.mockLogger = context.mock(log.class);
        tm2 = new TwitterMonitorV2(tweets, users, hashtags, dates);
        tm2.setLogger(mockLogger);
    }
    
    @Test
    public void testGetMostRetweeted() {
        final Twitter dummy = new Twitter("Dummy", "123", "30 Sep 2014 08");
        dummy.setRetweetCount(1000);
        context.checking(new Expectations() {
            {
                oneOf(tweets).getMostRetweetTweet();
                will(returnValue(dummy));
            }
        });
        assertTrue(tm2.getMostRetweetTweet().getRetweetCount()
                == dummy.getRetweetCount());
        
    }




    @Test
    public void methodThatWeExpectWillThrowAnException() {
        boolean expectedThrown = false;

        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            expectedThrown = true;
        }

        assertTrue(expectedThrown);
    }
    
    @Test
    /**
     * Compare Retweet count between the tweets and it's user.
     * Total retweet count of twitter's User is higher than
     * the tweet retweet count thus, total retweet count of
     * Most retweeted user is higher or equal to most retweet
     * tweet.
     * */
    public void UserRetweetCountVsTwitterRetweetCount() {
        final Twitter dummy = new Twitter("Dummy", "123", "30 Sep 2014 08");
        dummy.setRetweetCount(1000);
        final User dummyUser = new User("Dummy");
        dummyUser.setTotalRetweet(2000);
        context.checking(new Expectations() {
            {
                oneOf(tweets).getMostRetweetTweet();
                will(returnValue(dummy));
                oneOf(users).getMostRetweetUser();
                will(returnValue(dummyUser));
            }
        });
        assertTrue(tm2.getMostRetweetTweet().getRetweetCount()
                <= tm2.getMostRetweetUser().getTotalRetweet());
    }

    @Test
    /**
     * Testing the peak of twitter's created.
     * */
    public void getTheMostTimeTwitterisBeingCreated() {
        final TwitterDate dummyDate = new TwitterDate("30 Sep 2014 08");
        dummyDate.setTotalCreated(1000);
        context.checking(new Expectations() {
            {
                oneOf(dates).getMostPeak();
                will(returnValue(dummyDate));

            }
        });
        assertTrue(tm2.getMostPeak().getTotalCreated()
                == dummyDate.getTotalCreated());
    }
    
    @Test
    /**
     * If user call the statistic,
     * the method will printout the result to the monitor.
     *
     * */
    public void ifGetTheMostRetweetUserWriteIntoLogger() {
        final TwitterDate dummyDate = new TwitterDate("30 Sep 2014 08");
        final User dummyUser = new User("Dummy");
        final Twitter dummy = new Twitter("Dummy", "123", "30 Sep 2014 08");
        context.checking(new Expectations() {
            {
                atLeast(1).of(mockLogger).writeToLog("Get the most Retweet");

                oneOf(dates).getMostPeak();
                will(returnValue(dummyDate));
                
                oneOf(tweets).getMostRetweetTweet();
                will(returnValue(dummy));
                oneOf(users).getMostRetweetUser();
                will(returnValue(dummyUser));
                
                oneOf(mockLogger).writeToFile(dummy, dummyUser, dummyDate);
                will(returnValue(true));

            }
        });
        assertTrue(tm2.writeStaticticRetweet());
    }

    
    
}
/**
 * Interface for List of...
 *
 * */
interface ListOfTweets {
    public Twitter getMostRetweetTweet();
    public Twitter getMostRepliedTweet();
}

interface ListOfUsers{
    public User getMostRetweetUser();
    public User getMostRepliedUser();
    public User getUserfromTweet(Twitter t);
}

interface ListOfHashtag {
    public HashTag getMostUsedHashtag();
    public HashTag getMostOccurHashtag();
}

interface ListOfTwitterDate {
    public TwitterDate getMostPeak();
}

interface log {
    public void writeToLog(String Message);
    public boolean writeToFile(Twitter t, User s, TwitterDate td);
}

/**
 * Implementation of TwitterMonitorV2
 * */
class TwitterMonitorV2 {
    private ListOfTweets tweetsList = null;
    private ListOfUsers usersList = null;
    private ListOfHashtag hastags = null;
    private ListOfTwitterDate dates = null;
    private log logger = null;
    
    public TwitterMonitorV2( ListOfTweets t,
            ListOfUsers u, ListOfHashtag h,
            ListOfTwitterDate td) {
        this.tweetsList = t;
        this.usersList = u;
        this.hastags = h;
        this.dates = td;
    }
    
    public void setLogger(log logger) {
        this.logger = logger;
    }
    
    /**
     * Some method
     **/
    public Twitter getMostRetweetTweet() {
        return tweetsList.getMostRetweetTweet();
    }
    
    public User getUserFromTwitter(Twitter t) {
        return usersList.getUserfromTweet(t);
    }
    
    public User getMostRetweetUser() {
        return usersList.getMostRetweetUser();
    }
    
    public TwitterDate getMostPeak() {
        return dates.getMostPeak();
    }
    
    public boolean writeStaticticRetweet() {
        logger.writeToLog("Get the most Retweet");
        TwitterDate  td = dates.getMostPeak();
        Twitter t = tweetsList.getMostRetweetTweet();
        User s = usersList.getMostRetweetUser();
        return logger.writeToFile(t, s, td);
    }

}


