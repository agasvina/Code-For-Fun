function getRandomNumber(upper) {
  return Math.floor( Math.random() * upper ) + 1;
}

var number = getRandomNumber(10000);
var count = 0;
var guess = -1;
while(guess !== number) {
  guess = getRandomNumber(10000);
  count++;
}

document.write("<p> Computer guess.. " + count + " times </p>" );

/*
var randNumGuess = getRandomNumber(10);
count = 0;
var guess = -1;
do {
 var guess2 = prompt("Guess a valid number number");
 if( isNaN(guess2) ) {
    alert("Please enter a valid number!!!"); 
 } else {
   guess = parseInt(guess2); 
 }
  count++;
} while(guess !== randNumGuess);

document.write("<p> You've guess... " + count + " times; the right number is..." + randNumGuess + "</p><br>");
*/
//This is a for loop:
document.write("<p>")
for(var i = 0; i <10; i++) {
  //Wow br can be used inside <p> element! Neat!
 document.write( i+  " times <br>" ); 
}

document.write("<br> <br> The color rgb value:");

//Exit loop in java script: break?
var warna = [];
for(var i = 0; i <3; i++) {
 warna.push(getRandomNumber(255)); 
 document.write( warna[i] + " " );
}

document.write("</p>");

//Making an array of java script!!
//Using an array.. it's similar to the way it's called in Java
/*
Java script array start with 0 index as well.
*/


function printList( list ) {
  var listHTML = '<ol>';
  for (var i = 0; i < list.length; i += 1) {
    listHTML += '<li>' + list[i] + '</li>';
  }
  listHTML += '</ol>';
  print(listHTML);
}

function print(html) {
  var outputDiv = document.getElementById('output');
  outputDiv.innerHTML = html;
}

var wow = ["foo", "bar"];
printList( wow );

var quiz = [[]];
var dummy = "abc";
for(var i = 0; i < 3; i++) {
  quiz.push([dummy.charAt(i), i]);
}
quiz.shift();


function printList2( list ) {
  var listHTML = '<ol>';
  for (var i = 0; i < list.length; i += 1) {
    listHTML += '<li>' + list[i].join(", ") + '</li>';
  }
  listHTML += '</ol>';
  return listHTML;
}
print( printList2( quiz ) );


//creating an object in javascript
var oblivion = {
  name : 'oblivion',
  type : ' sword',
  power: 123
};


function Weapon( name, type, power) {
  this.name = name;
  this.type = type;
  this.power = power;
  
}

var oathKeeper = new Weapon('oathkeeper', 'sword',189);
function printObj( objWeapon) {
    for (var prop in objWeapon) {
     console.log(prop + " : " + objWeapon[prop] );
    }
}

printObj(oathKeeper);

function AddWeapon(html) {
  var outputDiv = document.getElementById('kill');
  outputDiv.innerHTML = html;
}


var weapons =[];
weapons[0] = new Weapon('excalibur', 'sword', 145);
weapons[1] = new Weapon('masamune', 'katana', 456);
weapons[2] = oathKeeper;
weapons[3] = oblivion;

weapons.sort(compareWeapon);
for(var i = 0; i < weapons.length;i++) printObj(weapons[i]);
//sorting based on value in JavaScript!:
function compareWeapon (w1, w2) {
  if(w1.power > w2.power) return 1;
  return -1;
}


//function to add weapon and properties to a list... 
function makeList ( objects ) {
  var result = "";
  for(var i = 0; i < objects.length; i++) {
   for( var key in objects[i] ) {
      if(key === 'name') {
       result = result + "<h3>" + objects[i][key].toUpperCase() + "</h3> <ol>";  
      } else {
       result += "<li>" + key + ": " + objects[i][key] + "</li>";
      }

   }//eofk
     result += "</ol>";
  }//eofi
  return result;
}

AddWeapon( makeList (weapons));
/*
<h3> Weapon Name </h3>
<ol>
  <li> Test  </li>
  <li> Dummy </li>
<ol>

<h3> Weapon Name </h3>
</ol>
  <li> Test  </li>
  <li> Dummy </li>
</ol>

*/




