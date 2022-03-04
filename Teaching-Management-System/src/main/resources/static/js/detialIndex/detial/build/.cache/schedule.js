/*TMODJS:{"version":3,"md5":"d89f50d4eae8fe17c72b4b5a15e6aa98"}*/
template('schedule',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,faculty=$data.faculty,major=$data.major,level=$data.level,grade=$data.grade,fileName=$data.fileName,fileType=$data.fileType,path=$data.path,$out='';$out+='<div class="schedule-content-btn" id="teachschedule"> <p>';
$out+=$escape(faculty);
$out+=' ';
$out+=$escape(major);
$out+=' ';
$out+=$escape(level=0?'本科':'专科');
$out+=' ';
$out+=$escape(grade+'级');
$out+=$escape(fileName);
$out+=' ';
$out+=$escape(fileType);
$out+='</p> </div> <div class="schedule-content-message"> <iframe src="';
$out+=$escape(path);
$out+='" id="" width="100%" height="100%">此处为PDF文档</iframe> </div>';
return new String($out);
});