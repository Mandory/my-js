// Correctness 100%
// Performance 33%
// Reference : https://github.com/OSerHuang/Codility/blob/master/Python/challenges/MaxPathFromTheLeftTopCorner.py

function solution(A) {

    const visited = Array.from(Array(A.length), () => new Array(A[0].length))
    for(let i=0; i<A.length; i++) {
        for(let j=0; j<A[0].length; j++) {
            if(i===0 && j===0) {
                visited[0][0] = `${A[0][0]}`;
                continue;
            }
            let right = '';
            let down = '';
            if(j-1 >= 0) {
                right = `${visited[i][j-1]}`;
            }
            if(i-1 >= 0) {
                down = `${visited[i-1][j]}`;
            }

            visited[i][j] = `${right > down ? right : down}${A[i][j]}`;
        }
    }
    return visited[A.length-1][A[0].length-1];
}