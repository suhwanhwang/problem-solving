#! /bin/bash
source_file=c.cpp
download_dir=~/Downloads

if [ "$#" -ne 1 ]; then
    for input_file in `ls $download_dir`; do
        mv $download_dir/$input_file .
    done
else
    input_file=$1
fi

if test -f ./$input_file
then
    g++ -std=c++11 -O2 $source_file
    time ./a.out < $input_file | tee ${input_file%.*}.out
else
    echo "[$input_file] not found."
fi