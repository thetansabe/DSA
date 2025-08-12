<h2><a href="https://leetcode.com/problems/powx-n">Pow(x, n)</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Implement <a href="http://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(x, n)</a>, which calculates <code>x</code> raised to the power <code>n</code> (i.e., <code>x<sup>n</sup></code>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> x = 2.00000, n = 10
<strong>Output:</strong> 1024.00000
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> x = 2.10000, n = 3
<strong>Output:</strong> 9.26100
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> x = 2.00000, n = -2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
	<li><code>n</code> is an integer.</li>
	<li>Either <code>x</code> is not zero or <code>n &gt; 0</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
</ul>

### Explain the 'whys' in the algo:
<img width="1227" height="773" alt="image" src="https://github.com/user-attachments/assets/70dd1599-1f1b-42af-ab5b-2b96b0aa8462" />

a^b = 2^13 = 2^6 * 2^6 * 2 = ...

Step 1: remove standalone 2 => res = res * 2 => we only have 2^6 * 2^6 left

Step 2: 2^6 * 2^6 = 2^(2^6) = 4^6 = (a^2)^(b/2) with a, b from step 1

Step 3: 4^6 = 4^3 * 4^3 = 4^(2*3) = 16^3 = (a^2)^(b/2) with a, b from step 2 

=> for each iteration, a = a^2 = a*a; b = b / 2;

...the following...

When a^b = 256^1, res *= 256; b/2 = 1/2 = 0 => stop loop
