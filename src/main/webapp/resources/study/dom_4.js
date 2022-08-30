
const ch = document.getElementsByClassName('ch');
const cb = document.getElementsByClassName('cb');
const all = document.getElementById('all');

for(let i=0;i<ch.length;i++){
    ch[i].addEventListener('click',function(){
        alert(ch[i].value);
    })
}


all.addEventListener('click',function(){

    for(let i=0; i<cb.length; i++) {
        if(all.checked) {
            cb[i].checked = true;

            cb[i].addEventListener('click',function(){
                let count=0;
                for(let i=0; i<cb.length; i++){
                    if(cb[i].checked==false){
                        all.checked=false;
                    }

                    if(cb[i].checked){
                        count++;
                        if(count==cb.length){
                            all.checked=true;
                        }
                    }
                }           
            })
        }else{
            cb[i].checked = false;
        }
    }
})