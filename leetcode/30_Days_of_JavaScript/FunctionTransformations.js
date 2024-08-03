/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    
    return function(x) {
       let y=x;
       for(let i=functions.length-1;i>=0;i--) {
            y=functions[i](y);
       }
       return y;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */

/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    return args.length;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */


/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    let called=false;
    let savedFunction=fn;
    return function(...args){
        if(!called){
            called=true;
            return savedFunction(...args);
        }
        return undefined;
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    let memo= new Map();
    let initFn=fn;
    return function(...args) {
        if(args.length==1){
            if(memo.get(args[0])==undefined){
                memo.set(args[0],initFn(...args));
            }
            return memo.get(args[0]);
        }
        else{
            if(memo.get(args[0])==undefined){
                memo.set(args[0],new Map());
            }
            if(memo.get(args[0]).get(args[1])==undefined){
                memo.get(args[0]).set(args[1],initFn(...args));
            }
            return memo.get(args[0]).get(args[1]);
        }
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
