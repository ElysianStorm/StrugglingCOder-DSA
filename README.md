# StrugglingCOder-DSA

**Top Of The Morning Lads**

"CODING IS EASY" - This is the most honest lie that bothers me and it all begins with DSA, the ruthless gatekeeper to all interviews, all opportunities. 

I admit I am not the best, nor the fastest, nor even the brightest of coders out here, but while I explore my journey trying to be-friend this scary beast called DSA and his minion questions, maybe, you too can find your way into loving DSA (if not, well, atleast clear those interviews). So here is my journal of the adventures I have with these imaginary monsters: **-**

# **A journey of tackling DSA questions while trying to keep sanity**
 
In this journal, I will keep posting solved approaches for questions in leetcode, interviewbit, geeksforgeeks (anywhere where that question shows up) along with the links to the solutions in which I explain my understanding of the question as someone who accepts DSA is not fun. However its not a random series of questions. The goal is to be-friend these imaginary monsters, so I will be systematic in my approach.

Here is how I am approaching DSA:
- [Bit Manipulation](#BIT-MANIPULATION)
- Maths
- [Arrays](#ARRAYS)
- Strings
- HashMaps
- Two Pointers
- Binary Search
- Sliding Window
- Recursion
- Stacks
- Linked Lists
- Trees
- Queues
- Tries                ---> I AM HERE NOW!!!

Planned, don't know if it will remain the same
- Backtracking
- Heaps/Priority Queues
- 1D DP
- 2D DP
- Graphs
- Greedy
- FINAL BOSSES

Cheers,

Your Struggling COder;

## **BIT MANIPULATION**

<details>
 <summary>Bit Manipulation: The first/last step</summary>
 
Bit Manipulation surely isn't the first thing that comes to people's mind when they want to start there DSA journey (and I did agree to it till a long time), but I have come to realise if done first, it builds in a practice to code in the most optimized way in the long run. Since bit manipulation works closest to the machine, it speeds up the algorithms significantly faster.

In my experience bit manipulation has opened for me avenues in places where dumber me would have never thought to use it (binary search, powers of twos, masking, simple loops and much more). So, without any further ado, lets dig in what we need to learn in bit manipulation before we head to the questions (This is sort of classwork before doing homework, yeah poor example but its true).

1. Operators (AND, OR, XOR, NOT, Left Shift, Right Shift)
2. Decimal -> Binary
3. Binary -> Decimal
4. Addition/Subtraction on bits
5. Odd/Even numbers
6. Swap two numbers
7. Bit Masking
8. Find ith bit
9. Set ith bit
10. Clear ith bit
11. Find number of bits to convert number A to number B

These questions set us up for bit manipulation, with these questions we know mostly how to deal with bits (mostly cause some questions are designed to fail your logic). Now we can dive in the depths of our homework.
A sweet search in CHAT-GPT gives this roadmap for bit manipulation along with some practice questions (yeah, I rely on chat-gpt):

Roadmap to Learning Bit Manipulation:

1. Binary Basics
   - Conversion: Decimal to Binary
   - Understanding Bit Representation
   - LeetCode: [Total Set Bits](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/BitManipulation/RunningTotalSetBits.java)

2. Bitwise Operations
   - AND, OR, XOR, NOT
   - Application in Setting/Clearing Bits
   - LeetCode: [Single Number](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/BitManipulation/SingleNumber.java), [Single Number II](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/BitManipulation/SingleNumber2.java)

3. Shift Techniques
   - Left Shift (<<), Right Shift (>>)
   - Arithmetic Right Shift (>>>)
   - LeetCode: [Reverse Bits](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/BitManipulation/ReverseBitsOfNumber.java)

4. Tricks & Techniques
   - Even/Odd Check
   - Swapping Values without Temp Variables
   - LeetCode: [Hamming Weight](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/BitManipulation/HammingWeight.java), [Is Power of Two](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/BitManipulation/IsPowerOfTwo.java)

5. Language Integration
   - Implementing Bitwise Operations in Different Languages
   - Handling Bit Manipulation in Python, Java, etc.
   - LeetCode: [XOR in Subarray](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/BitManipulation/XorInSubArrays.java)

6. Algorithmic Applications
   - Optimizing Algorithms with Bit Manipulation
   - Bitwise XOR Properties
   - InterviewBit: [Min XOR Value](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/BitManipulation/MinXorValue.java)
</details>

## **ARRAYS**

<details>
 <summary>Arrays: The core of programming</summary>

 If it wasn't for arrays, computer programming would have probably not existed (thats my view on how important I feel arrays are, you are delightfully welcomed to think differently, but admit it, you too have a soft corner for arrays within you!). From the most simplest questions to the most complex and non intuitive questions, arrays are almost everywhere. So it is obvious to try and learn arrays and how to deal with them. 
 
 To put it simply, arrays are a list of anything, from primitive data types (numbers, characters, strings) to objects (if you are into object oriented programming) and complex data structures. Working with arrays can sometimes be hard (yeah, we all have been there when some questions on arrays just don't make any sense), but working with those questions too rely on the basics of arrays. So lets understand what are the basic operations we do with arrays (this is almost always similar for all data structures, be it linked lists, queues, stacks, trees, with some added functionality specific to the data structures). These operations are what makes up the in-built functions for arrays in many programming languages. You may ask why are we doing this then, when a simple call to those functions can do the work for us. Well, its always better to know your arsenal of weapons before heading to a fight. So lets see the weapons we need to master for facing array questions:
 
 1. Creating and initialising arrays in different ways with different types of data
 2. Finding element in array
 3. Finding index of element in array
 4. Finding element satifying condition
 5. Finding index of element satisfying condition
 6. Iterating over arrays in different ways (linear, jumps, conditional, back and front one after other and simultaneously)
 7. Inserting element in array at index of choice
 8. Deleting element from array at index of choice
 9. Updating element in array at index of choice
 10. Sorting arrays in different ways
 11. Merging arrays with other arrays
 12. Copying part of arrays (subarrays)

This list is neccessary but not sufficient, these core exercises set the premises for any array fundamental question. However, these alone do not solve array questions. For that we have to practice mastering the use of weapons we possess (i.e. practice approaching questions logically and deducing patterns and working on that). These questions are some of the few that give insight into many of the patterns that keep recurring in array based questions:

- [Minimum Lights To Activate](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/Arrays_HashMaps_Strings/MinimumLightsToActivate.java)
- [Find Occurence Of Each Number](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/Arrays_HashMaps_Strings/FindOccurencesOfEachNumber.java)
- [Longest Consecutive Subsequence](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/Arrays_HashMaps_Strings/LongestConsecutiveSubsequence.java)
- [Maximum Subarray](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/Arrays_HashMaps_Strings/MaxSubArray.java)
- [Spiral Order](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/Arrays_HashMaps_Strings/SpiralOrder.py)
- [Transpose Matrix](https://github.com/ElysianStorm/StrugglingCOder-DSA/blob/main/Arrays_HashMaps_Strings/TransposeMatrix.java)

NOTE: These questions still deal with the basics of arrays, some of the patterns in arrays are so common that they become a topic on there own (such as Two Pointers, Binary Search, Sliding Window and more).
</details>
