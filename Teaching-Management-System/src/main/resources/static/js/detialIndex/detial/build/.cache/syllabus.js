/*TMODJS:{"version":3,"md5":"43656fe400d7a060f2393ef105741889"}*/
template('syllabus',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,faculty=$data.faculty,major=$data.major,level=$data.level,grade=$data.grade,fileName=$data.fileName,fileType=$data.fileType,path=$data.path,$out='';$out+='<div class="schedule-content-btn" id="syllabus"> <p>';
$out+=$escape(faculty);
$out+=' ';
$out+=$escape(major);
$out+=' ';
$out+=$escape(level=0?'本科':'专科');
$out+=' ';
$out+=$escape(grade+'级');
$out+=' ';
$out+=$escape(fileName);
$out+=' ';
$out+=$escape(fileType);
$out+='</p> </div> <div class="schedule-content-message"> <iframe src="';
$out+=$escape(path);
$out+='" id="" width="100%" height="100%">此处为PDF文档</iframe> </div>';
return new String($out);
});