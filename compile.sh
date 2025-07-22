#!/bin/bash

# Set output directory
OUT_DIR=out

# Create the output directory if it doesn't exist
mkdir -p $OUT_DIR

# Compile all .java files into the output directory
javac -d $OUT_DIR $(find . -name "*.java")

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "✅ Compilation successful. Classes are in '$OUT_DIR'."
else
    echo "❌ Compilation failed."
fi

