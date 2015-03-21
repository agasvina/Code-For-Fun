#include <iostream> 
#include <string> 
#include <vector> 
#include <algorithm> 
#include <functional> 
#include <numeric> 
#include <cstdio> 
#include <cstdlib> 
#include <cmath> 
#include <queue> 
#include <set>
#include <map>



//this one is one of neat macro.
#define tr(container, it) for(typeof(container.begin()) it = container.begin(); it != container.end(); it++) 


//one of useful macro... define.. 
#define all(c) c.begin(), c.end()
using namespace std; 
typedef vector<int> VI;  typedef vector<vector<int> > VVI; 
typedef vector<string> VS;  typedef vector<vector<string> > VVS; 
typedef signed long long i64;  typedef unsigned long long u64; 


class MNS { 
public: 
int combos(vector <int> a) { 
  int i, j, k, x, y, z, n; 
  int ret = 0; 

  sort(a.begin(), a.end()); 
  do { 
    x = a[0]+a[1]+a[2]; 
    ret += (x == a[3]+a[4]+a[5] && 
        x == a[6]+a[7]+a[8] && 
        x == a[0]+a[3]+a[6] && 
        x == a[1]+a[4]+a[7] && 
        x == a[2]+a[5]+a[8]); 
  } while( next_permutation(a.begin(), a.end()) ); 
  return ret; 
} 
}; 


int main() {
//this is an easier way to initialize array in C++
 int arr[] = {1,5,1,2,5,6,2,3,2};
vector<int> vec (arr, arr + sizeof(arr) / sizeof(arr[0]) );
MNS *mns = new MNS();
cout << mns -> combos(vec) << endl;
//testing to iterate for vector. 
//this is reverse.
cout << "Reverse the vector" << endl;
for(vector<int>::iterator it = vec.end(); it!= vec.begin(); it--) {
	//increment to the value of inside the vector... 
	//Nice
	cout << *it << endl; 
}

//Here is a neat example to get the index of element found.
int i = (find(vec.begin(), vec.end(), 5) - vec.begin());
cout <<"The index of 5 is: " << i << endl;

//and dude we have min_element and max_element in #include<algorithm>
//example for returning the max_element and the index of the vector. 
int maxVec = *max_element(vec.begin(), vec.end());
int minVec = *min_element(all(vec));
int idVec = max_element(vec.begin(), vec.end()) - vec.begin();
cout << "Max Value: " << maxVec << " ;Located in the index: " << idVec << endl; 
cout << "Min Value: " << minVec << endl;

//and we also have a reverse iterator dude... 
//this is fucking cool:
sort(vec.rbegin(), vec.rend()); // Sort array in descending order using with reverse iterators
vector<int>::iterator its;
its = vec.begin();
vec.insert(its, 765);
for(vector<int>::iterator it = vec.begin(); it != vec.end(); it++) {
	cout << " " << *it;
}



//next we learn Compiling STL program. 
// neat.

//the type string 
// substr(0,3); ... inclusive, exklusive
//Example of using set! Hahaha! this is fucking cool
set <int> s;

for(int i = 1; i <=100; i++) {
	s.insert(i); //insert 100 element>> 1 -- 100 inclusive
}

//now erase the even value of the set.
for(int i = 2; i <= 100; i+= 2) {
s.erase(i); //erase the even values
}

cout << "The size of the set s: " << s.size() << endl;
//Note that push back is not use in size
//for the set we need to use iterator. 
//lets try to calculate all the element of the set. 
int r = 0;
for(set<int>::const_iterator it = s.begin(); it != s.end(); it++) {
r+= *it;
}

cout << "Sum of the set s: " << r << endl;

char c = '1';
int cValue = (int) c;
cout << cValue << endl;

cin.get();
return 0;
}




