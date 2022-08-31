
const ch = document.getElementsByClassName('ch');
const cb = document.getElementsByClassName('cb');
const all = document.getElementById('all');

for(let i=0;i<ch.length;i++){
    ch[i].addEventListener('click',function(){
        alert(ch[i].value);
    })
}
//----------------------------------------------------

all.addEventListener('click',function(){
    for(let i=0;i<cb.length;i++){
        cb[i].checked = all.checked;
    }
})

for(let i=0;i<cb.length;i++){
    cb[i].addEventListener('click',function(){
        let result = true;
        for(let j=0; j<cb.length; j++){
            if(!cb[j].checked){
                result=false;
                console.log(i,':',cb[i].checked)
                break;
            }
        }
        all.checked = result;
    })
}