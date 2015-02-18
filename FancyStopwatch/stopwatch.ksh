#!/bin/ksh

MIN=$1 && for i in $(seq $(($MIN*60)) -1 1);
do
echo -n "$i, " > output.txt;
sleep 1;
done;
open ./awesome.html;
say "Luke, You are awesome";
say "Stop what you are doing right now";
rm ./output.txt;


