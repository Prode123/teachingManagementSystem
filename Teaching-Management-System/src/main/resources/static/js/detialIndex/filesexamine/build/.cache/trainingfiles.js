/*TMODJS:{"version":32,"md5":"8889594c558f583b542273584ccd5596"}*/
template('trainingfiles',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,faculty=$data.faculty,major=$data.major,grade=$data.grade,fileName=$data.fileName,path=$data.path,$out='';$out+='<div class="trainingfiles" id="file"> <p>';
$out+=$escape(faculty);
$out+=' ';
$out+=$escape(major);
$out+=' ';
$out+=$escape(grade+'级');
$out+=' ';
$out+=$escape(fileName);
$out+=' <button class="nopass">不通过</button> <button class="pass">通过</button> </p> </div> <div class="file-content"> <iframe src="';
$out+=$escape(path);
$out+='" id="" width="100%" height="100%">此处为PDF文档</iframe> </div>';
return new String($out);
});