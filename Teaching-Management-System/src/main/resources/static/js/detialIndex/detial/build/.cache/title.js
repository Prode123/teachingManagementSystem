/*TMODJS:{"version":21,"md5":"6e6ca6d05f0768c0ddcc6c7760e91c9c"}*/
template('title',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,grade=$data.grade,major=$data.major,level=$data.level,fileType=$data.fileType,path=$data.path,$out='';$out+='<div class="schedule-content-btn" id="training"> <p>';
$out+=$escape(grade);
$out+=' ';
$out+=$escape(major);
$out+=' ';
$out+=$escape(level=0?'本科':'专科');
$out+=' ';
$out+=$escape(fileType);
$out+='</p> </div> <div class="schedule-content-message"> <iframe src="';
$out+=$escape(path);
$out+='" id="" width="100%" height="100%">此处为PDF文档</iframe > </div>';
return new String($out);
});