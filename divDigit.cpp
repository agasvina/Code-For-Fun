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
#include <stdio.h>
#include <stdlib.h>

using namespace std;

class DivisorDigits {
	public:
	int howMany(int number) {
		int res = 0;
		string temp = to_string(number);
		for(int i = 0; i < temp.length(); i++) {
			if(number % ((int)temp.at(i) - 48) == 0) res++;
		}
		return res;
	}
};


/*public class DivisorDigits {
	
	public static int howMany(int  n) {
	int res= 0;
	String temp = n + "";
	for(int i = 0 ; i < temp.length(); i++) {
		if(n% Integer.parseInt(temp.charAt(i)+"") == 0) {
		res++;
		}
	
	}
	return res;
	}

}*/



