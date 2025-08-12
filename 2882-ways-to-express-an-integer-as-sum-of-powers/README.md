<h2>DP - Target Sum problem</h2>

<h2><a href="https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers">Ways to Express an Integer as Sum of Powers</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given two <strong>positive</strong> integers <code>n</code> and <code>x</code>.</p>

<p>Return <em>the number of ways </em><code>n</code><em> can be expressed as the sum of the </em><code>x<sup>th</sup></code><em> power of <strong>unique</strong> positive integers, in other words, the number of sets of unique integers </em><code>[n<sub>1</sub>, n<sub>2</sub>, ..., n<sub>k</sub>]</code><em> where </em><code>n = n<sub>1</sub><sup>x</sup> + n<sub>2</sub><sup>x</sup> + ... + n<sub>k</sub><sup>x</sup></code><em>.</em></p>

<p>Since the result can be very large, return it modulo <code>10<sup>9</sup> + 7</code>.</p>

<p>For example, if <code>n = 160</code> and <code>x = 3</code>, one way to express <code>n</code> is <code>n = 2<sup>3</sup> + 3<sup>3</sup> + 5<sup>3</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10, x = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> We can express n as the following: n = 3<sup>2</sup> + 1<sup>2</sup> = 10.
It can be shown that it is the only way to express 10 as the sum of the 2<sup>nd</sup> power of unique integers.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 4, x = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can express n in the following ways:
- n = 4<sup>1</sup> = 4.
- n = 3<sup>1</sup> + 1<sup>1</sup> = 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>1 &lt;= x &lt;= 5</code></li>
</ul>

# Memoize algo:
<img width="1380" height="553" alt="image" src="https://github.com/user-attachments/assets/96acbd7c-45e4-4c0d-8c6a-0bb60ac60f41" />

### Design cache
Why the cache size is N x N?

<img width="718" height="375" alt="image" src="https://github.com/user-attachments/assets/c272f381-edb5-490f-b669-6bc44697bbad" />

The cache will tells us, at position i and target j, we need to + `a` more to get the final target.

So `a` will be another base target

j = target = maxTarget = 300, we cannot change this

i = 1 to sqrt(300) but I use 300 anyways

The cache size can be reduce to sqrt(N) * target

<b>Follow up: We can resize the cache down to 2 * target?</b>

### Time complexity: O(N^2)
We cached the base calculation => number of item in cache is number of base calculation

=> O(i*j) = O(sqrt(N) * target)
