/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor varytec.
 */

function conditional_focus(obj,val,ieq,ineq){
  
  if(document.getElementById(obj).value==val){
    $(PrimeFaces.escapeClientId(ieq)).focus();
  }else{
    $(PrimeFaces.escapeClientId(ineq)).focus();
  }
      
  
}


function  tabular(e,obj) 
{
  
  tecla=(document.all) ? e.keyCode : e.which;
  if(tecla!=13) return;
  frm=obj.form;
  for(i=0;i<frm.elements.length;i++) 
    if(frm.elements[i]==obj) 
    { 
      if (i==frm.elements.length-1) 
        i=-1;
      break 
    }
  /*ACA ESTA EL CAMBIO disabled, Y PARA SALTEAR CAMPOS HIDDEN*/
  if ((frm.elements[i+1].disabled ==true) || (frm.elements[i+1].type=='hidden') )    
    tabular(e,frm.elements[i+1]);
  /*ACA ESTA EL CAMBIO readOnly */
  else {
    if (frm.elements[i+1].readOnly ==true )    
      tabular(e,frm.elements[i+1]);
    else {
      if (frm.elements[i+1].type=='text') /*VALIDA SI EL CAMPO ES TEXTO*/
      {
        frm.elements[i+1].select();
      };   /* AÑADIR LOS CORCHETES Y ESTA INSTRUCCION */
      window.scroll(0, findPos(frm.elements[i+1])-400);
      frm.elements[i+1].focus();
      
    }
  }
  return false; 
} 

function findPos(obj) {
    var curtop = 0;
    if (obj.offsetParent) {
        do {
            curtop += obj.offsetTop;
        } while (obj = obj.offsetParent);
    return [curtop];
    }
}
/**
 *e - evento
 *obj - el objeto que llama est funcion
 *val - el valor esperado
 *ieq - el componente al que se pasa el foco en caso de que se tenga el valor esperado
 **ieq - el componente al que se pasa el foco en caso de que NO se tenga el valor esperado
 */
function tabular2(e,obj,val,ieq,ineq) 
{
  tecla=(document.all) ? e.keyCode : e.which;
  if(tecla!=13) return;
  frm=obj.form;
  ambos=false;
  i=0, j=0, k=0;
  for(f=0;f<frm.elements.length;f++) {
    if(frm.elements[f]==obj) { 
      if (f==frm.elements.length-1) {
        f=-1;
      }
      i=f;
      //break ;
    }
    if(frm.elements[f].id==ieq){
      j=f;
    }
    if(frm.elements[f].id==ineq){
      k=f;
    }
  }
  /*ACA ESTA EL CAMBIO disabled, Y PARA SALTEAR CAMPOS HIDDEN*/
  if ((frm.elements[i+1].disabled ==true) || (frm.elements[i+1].type=='hidden') )    
    tabular(e,frm.elements[i+1]);
  /*ACA ESTA EL CAMBIO readOnly */
  else {
    if (frm.elements[i+1].readOnly ==true )    
      tabular(e,frm.elements[i+1]);
    else {
      if (frm.elements[i+1].type=='text') /*VALIDA SI EL CAMPO ES TEXTO*/
      {
        if(frm.elements[i].value==val){
          frm.elements[j].select();
          frm.elements[j].focus();
          window.scroll(0, findPos(frm.elements[j+1])-400);
          return false;
        }
//        alert(j);
//        alert(i+1);
//        alert(i+2);
          frm.elements[k].select();
      };   /* AÑADIR LOS CORCHETES Y ESTA INSTRUCCION */
      window.scroll(0, findPos(frm.elements[k])-400);
      frm.elements[k].focus();
      
      
      
      
    }
  }
  return false; 
}


function checkAndDisable(e,obj,id,val) 
{  
  tecla=(document.all) ? e.keyCode : e.which;
  if(tecla!=13) return;
  frm=obj.form;
  //el disparador
  
  for(i=0;i<frm.elements.length;i++) {
    if(frm.elements[i]==obj ) 
    { 
      if (i==frm.elements.length-1) 
        i=-1;
      break 
    }
  }
  //la caja de texto desabilitada
  for(j=0;j<frm.elements.length;j++) {
    if(frm.elements[j].id==id ) 
    { 
      if (j==frm.elements.length-1) 
        j=-1;
      break 
    }
  }
    
  if(frm.elements[i].type=="text" && frm.elements[i].value==val){
    frm.elements[j].disabled=false;
    frm.elements[j].className="ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all";
    frm.elements[j].focus();
    frm.elements[j].select();
  }else{
    frm.elements[j].value="-";
    frm.elements[j].disabled=true;
    frm.elements[j].className="ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all ui-state-disabled";
    tabular(e, frm.elements[j]);
  }
  
  return false;
}  

function cUpper(cObj) 
{
cObj.value=cObj.value.toUpperCase();
}

function volver(){
history.back(); 
}