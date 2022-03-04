/*TMODJS:{"version":8,"md5":"6959952f24df2d1c162d86e8e2c85785"}*/
template('teamaward',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each($data,function($value,$index){
$out+=' <tr> <td>';
$out+=$escape($index + 1);
$out+='</td> <td>';
$out+=$escape($value.faculty);
$out+='</td> <td>';
$out+=$escape($value.pname);
$out+='</td> <td>';
$out+=$escape($value.plevel);
$out+='</td> <td>';
$out+=$escape($value.ptime);
$out+='</td> <td>';
$out+=$escape($value.psponsor);
$out+='</td> <td>';
$out+=$escape($value.number);
$out+='</td> <td><a href="';
$out+=$escape($value.path);
$out+='">查看详情</a></td> </tr> ';
});
return new String($out);
});