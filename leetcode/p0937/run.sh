#! /bin/bash
source_file=main.cpp

input_file=$1

if [ -f ./$input_file ]
then
    g++ -Wall -std=c++14 -O2 $source_file && time ./a.out < $input_file | tee ${input_file%.*}.out
else
    echo "[$input_file] not found."
fi