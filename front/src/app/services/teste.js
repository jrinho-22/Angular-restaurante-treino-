/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    const values = root
    res = []
    res.push(root[0])
    root = root.slice(1)
    function recursice(array, index) {
        // console.log(array, index)
        resArray = array.slice(0, index)
        console.log(...resArray)
        res.push(resArray.reverse())
        newArray = array.slice(index)
        if (newArray.length) {
            recursice(newArray, index * 2)
        }

    }
    recursice(root, 2)
    console.log(res)
    console.log(res.flat())
    res.slice(1)
    console.log(res)
    
};

invertTree([4,2,7,1,3,6,9])