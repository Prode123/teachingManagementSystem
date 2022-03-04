/*TMODJS:{"version":2,"md5":"1dc52197fcc56877e2675e2b23048874"}*/
template('individual',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,items=$data.items,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each(items,function($value,$index){
$out+=' <tr> <td>';
$out+=$escape($value.order);
$out+='</td> <td>';
$out+=$escape($value.number);
$out+='</td> <td>';
$out+=$escape($value.parter);
$out+='</td> <td>';
$out+=$escape($value.competeType == 0? '单人赛' : '团体赛');
$out+='</td> <td>';
$out+=$escape($value.competeName);
$out+='</td> <td>';
$out+=$escape($value.awardType);
$out+='</td> <td>';
$out+=$escape($value.awardLevel);
$out+='</td> <td>';
$out+=$escape($value.parterTitle);
$out+='</td> <td>';
$out+=$escape($value.parterTeacher);
$out+='</td> <td>';
$out+=$escape($value.status);
$out+='</td> <td> <a href="';
$out+=$escape($value.detailsLink);
$out+='" target="_blank">查看详情</a> </td> </tr> ';
});
return new String($out);
});