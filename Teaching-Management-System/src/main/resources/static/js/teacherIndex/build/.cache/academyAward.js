/*TMODJS:{"version":21,"md5":"bb09595f53a959dc47674cf23954014e"}*/
template('academyAward',function($data,$filename
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