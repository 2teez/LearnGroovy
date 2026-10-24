#!/usr/bin/env python3

def fac(number):
  if number == 0:
      return 1
  else:
      return number * fac(number -1)

def main():
    print(fac(997))

if  __name__ == '__main__':
   main()
