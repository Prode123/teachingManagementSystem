/*TMODJS:{"version":21,"md5":"b9d5b7b36f629aaf86c790b518b23431"}*/
template('docTable',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each($data,function($value,$index){
$out+=' <tr> <td><input type="checkbox" class="td-checkbox" name="td-checkbox"></td> <td>';
$out+=$escape($value.fileName);
$out+='</td> <td>';
$out+=$escape($value.faculty);
$out+='</td> <td>';
$out+=$escape($value.major);
$out+='</td> <td>';
$out+=$escape($value.clazz);
$out+='</td> <td>';
$out+=$escape($value.fileType);
$out+='</td> <td> ';
if($value.status == 0){
$out+=' 待审核 ';
}else if($value.status == 1){
$out+=' 通过 ';
}else if($value.status == 2){
$out+=' 不通过 ';
}
$out+=' </td> <td> <a href="';
$out+=$escape($value.path);
$out+='" target="_blank">查看详情</a> </td> </tr> ';
});
return new String($out);
});