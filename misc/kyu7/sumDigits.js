/*
Summing a number's digits

Write a function named sumDigits which takes a number as input and
returns the sum of the absolute value of each of the number's decimal digits.

For example: (Input --> Output)
10 --> 1
99 --> 18
-32 --> 5

Let's assume that all numbers in the input will be integer values.
Categories : Fundamentals, Arithmetic, Mathematics, Algorithms, Numbers
*/
function sumDigits(number) {
    var i = 0;
    var sum = 0;
    number = Math.abs(number)
    while(number != 0)
    {
        sum += number % 10
        number = Math.floor(number/10)
    }
    return sum
}

const { assert } = require("chai")

describe("Basic tests", () => {
  it("Testing for fixed tests", () => {
    assert.strictEqual(sumDigits(10), 1);
    assert.strictEqual(sumDigits(99), 18);
    assert.strictEqual(sumDigits(-32), 5);
    assert.strictEqual(sumDigits(1234567890), 45);
    assert.strictEqual(sumDigits(0), 0);
    assert.strictEqual(sumDigits(666), 18);
    assert.strictEqual(sumDigits(100000002), 3);
    assert.strictEqual(sumDigits(800000009), 17);
    })
  })

describe("Random Tests", () => {

  function randint(min, max){
    return Math.floor(Math.random() * (max - min + 1)) + min
  }

  for(let i = 0; i < 100; i++){
    n = randint(-Math.pow(10, randint(1, 10)), Math.pow(10, randint(1, 10)))
    expected = [...""+Math.abs(n)].reduce((a, b) => a + +b, 0)
    it (`sumDigits(${n}) should equal ${expected}`, () => {
      assert.strictEqual(sumDigits(n), expected)
    })
   }
  })