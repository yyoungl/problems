
function solution(spell, dic) {
    var answer = 0;
    let dicCheck = [];
    
    for (d of dic) {
        let count = 0; 
        for (s of spell){
            if (d.includes(s)) {
                count ++;
            }
        }
        if (count == spell.length){
        dicCheck.push(d);
        }
    }
    
    
    return dicCheck.length !== 0 ? 1 : 2 ;
}


/*
dic.filter(d => spell.every(c => d.includes(s))) 

*/