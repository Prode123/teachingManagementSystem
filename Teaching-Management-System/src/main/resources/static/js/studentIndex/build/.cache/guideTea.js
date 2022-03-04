/*TMODJS:{"version":22,"md5":"4dcd31654eea78ce955348d16bee68d0"}*/
template('guideTea',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each($data,function($value,$index){
$out+=' <li> <span class="teaName">';
$out+=$escape($value.username);
$out+=' </span> <span class="teaDept">';
$out+=$escape($value.faculty);
$out+='</span> <span class="teaUId">';
$out+=$escape($value.uid);
$out+='</span> </li> ';
});
return new String($out);
});