
#include <forward_list>
#include <ios>
#include <iostream>
#include <iomanip>

long fac(long number);

int main(int argc, char** argv) {

    std::forward_list<int> numbers {5, 9, 23, 56, 120, 560};
    for (const auto &number: numbers) {
        std::cout << std::fixed;
        std::cout << std::right << std::setw(4) << number << ": "<< std::setw(4)
        << std::left << fac(number) << "\n";
    }

    return 0;
}

long fac(long number) {
    if (number == 0) return 1;
    else return number * fac(number -1);
}
