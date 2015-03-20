//#include <algorithm>

#include <iostream>
#include <iterator>
#include <string>
#include <vector>
#include <stdio.h>
#include <stdlib.h>
#include <sstream>

using namespace std;
//this is a container belong to all..
//which is kind of strange.


class ComboLength {
public:
	 ComboLength() {};
	int howLong(string moves) {
		int maxP1 = -1;
		int counter = 1;
		char prev = moves.at(0);
		for(string::iterator i = moves.begin()+1; i != moves.end(); i++) {
			//so the iterator become char.. hmmm interesting.
			if(*i == prev){
				counter++;
			} else {
				if(counter > maxP1)  maxP1 = counter;
				prev = *i; counter =1;
			}
		}
		if(maxP1 == -1) maxP1 = counter;
		return maxP1;
	};

};


class FractionSplit {
public:
	int n;
	int d;
	FractionSplit(int n, int d) {
		this->n = n;
		this->d = d;
	}
	//first of all I can't return an array of string...
	//array is not copyable.. I shall return vector<string>
	//this is really strange.
	 vector<string> getSum(int n, int d) {
		FractionSplit* temp = new FractionSplit(n,d);
		int counter = 2;
		vector<string> res;
		while(true) {
			int dummy = temp->d;
			int v= (temp->n * counter);
			if(dummy < v) {
				temp->n =  v - dummy;
				temp->d = temp->d * counter;
				string r = "1/";
				std::stringstream Stream;
				Stream << counter;
				r+= Stream.str();
			    res.push_back(r);
			} else if(dummy > v) {

			} else if(dummy == v) {
				string r = "1/";
				std::stringstream Stream;
				Stream << counter;
				r+= Stream.str();
			    res.push_back(r);
			    break;
			}
			counter++;
		}
		return res;
	};


};



int main() {
	ComboLength * dummy = new ComboLength();
	cout << dummy -> howLong("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA") << endl;
	FractionSplit * test = new FractionSplit(1,2);
	vector<string> t = test->getSum(4,5);
	for(vector<string>::iterator it = t.begin(); it != t.end(); it++) {
		cout << " " << *it;
	}



}

