/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        return "Hello World";
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */

/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    num=n-1;
    return function() {
        num=num+1;
        return num;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */

/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    make=val;
    return{
        toBe : function (varEq){
            if(make===varEq)
                return true;
            throw new Error("Not Equal")
        },
        notToBe : function (varNotEq){
            if(make!==varNotEq)
                return true;
            throw new Error("Equal")
        }
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let start=init;
    let num=init;
    const increment = function(){
        num++;
        return num;
    }
    const decrement = function(){
        num--;
        return num;
    }
    const reset = function(){
        num=start;
        return num;
    }
    return {increment, decrement, reset};
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
