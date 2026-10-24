#!/usr/bin/env bash
# author: omitida
# date: 2024/10/20
# Description:
#  Search using tree for a file

if [[ $# != 2 ]]; then
      echo "Usage: $0 <directory> <regex>"
      exit 1
fi

directory="$1"
regex="$2"

find -d -f "$directory" | grep -i "$regex"
