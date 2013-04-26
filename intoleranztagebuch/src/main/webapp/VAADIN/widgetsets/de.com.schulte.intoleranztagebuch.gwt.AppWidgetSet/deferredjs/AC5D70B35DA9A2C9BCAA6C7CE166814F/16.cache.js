function wM(){}
function rM(){}
function T2(){}
function I4(){}
function dvb(){}
function cvb(){}
function _7b(){}
function p8b(){}
function t8b(){}
function x8b(){}
function B8b(){}
function q8b(b){this.b=b}
function u8b(b){this.b=b}
function y8b(b){bb();this.b=b}
function n8b(b,c){b.enctype=c;b.encoding=c}
function KBb(b,c){b.onload=Ppc(function(){c.Yf()})}
function J4(){var b;this.Ob=(b=$doc.createElement(Jrc),b.type=Trc,b)}
function C8b(b){var c;this.b=b;this.Ob=(c=$doc.createElement(Jrc),c.type='file',c);this.Ob[urc]='gwt-FileUpload'}
function b8b(b){_hb(b.n,false);b.o||(b.e.Ob[Erc]=true,undefined);b.d=false}
function c8b(b){_hb(b.n,true);b.e.Ob[Erc]=false;b.d=true;if(b.o){a8b(b);b.o=false}}
function a8b(b){if(b.p){$doc.body.removeChild(b.p);b.p.onload=null;b.p=null}}
function f8b(b,c){if(b.f!=c){b.f=c;if(b.f){c_(b.e,1024);c_(b.e,2048)}}O$(b.Ob,'v-upload-immediate',b.f)}
function e8b(b){E_(b.k,b.n);E_(b.k,b.e);b.e=new C8b(b);b.e.Ob.name=b.j+mAc;b.e.Ob[Erc]=!b.d;E3(b.k,b.e);E3(b.k,b.n);b.f&&c_(b.e,1024)}
function yM(){uM=new wM;Ub((Sb(),Rb),16);!!$stats&&$stats(xc(lAc,Ypc,-1,-1));uM.Qc();!!$stats&&$stats(xc(lAc,_xc,-1,-1))}
function vM(){var b,c,d;while(sM){d=nb;sM=sM.b;!sM&&(tM=null);if(!d){(qub(),pub).wg(gG,new dvb);Jlb()}else{try{(qub(),pub).wg(gG,new dvb);Jlb()}catch(b){b=oJ(b);if(Ar(b,37)){c=b;Mrb.He(c)}else throw b}}}}
function g8b(b){if(b.e.Ob.value.length==0||b.o||!b.d){Mrb.Je('Submit cancelled (disabled, no file or already submitted)');return}$ib(b.b);b.c.submit();b.o=true;Mrb.Je('Submitted form');b8b(b);b.q=new y8b(b);db(b.q,800)}
function d8b(b){var c;if(!b.p){c=$doc.createElement(Rrc);c.innerHTML="<iframe src=\"javascript:''\" name='"+b.j+"_TGT_FRAME' style='position:absolute;width:0;height:0;border:0'>"||Tpc;b.p=je(c);$doc.body.appendChild(b.p);b.c.target=b.j+'_TGT_FRAME';KBb(b.p,b)}}
function h8b(){this.Ob=$doc.createElement('form');this.e=new C8b(this);this.k=new H3;this.g=new J4;this.c=this.Ob;n8b(this.Ob,nAc);this.c.method='post';R1(this,this.k);E3(this.k,this.g);E3(this.k,this.e);this.n=new cib;V$(this.n,new q8b(this),(Dk(),Dk(),Ck));E3(this.k,this.n);this.Ob[urc]='v-upload';this.Lb==-1?CY(this.Ob,241|(this.Ob.__eventBits||0)):(this.Lb|=241)}
var mAc='_file',oAc='buttoncaption',lAc='runCallbacks16';_=wM.prototype=rM.prototype=new J;_.gC=function xM(){return Hu};_.Qc=function BM(){vM()};_.cM={};_=T2.prototype=new s$;_.gC=function U2(){return jx};_.Vc=function V2(b){Z$(this,b)};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=J4.prototype=I4.prototype=new s$;_.gC=function K4(){return yx};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=dvb.prototype=cvb.prototype=new J;_.Ue=function evb(){return new h8b};_.gC=function fvb(){return NA};_.cM={137:1};_=h8b.prototype=_7b.prototype=new O1;_.gC=function i8b(){return gG};_.md=function j8b(){Y$(this);!!this.b&&d8b(this)};_.Vc=function k8b(b){(CZ(b.type)&241)>0&&(ttb(this.b.I,b,this,null),undefined);Z$(this,b)};_.nd=function l8b(){$$(this);this.o||a8b(this)};_.Yf=function m8b(){ktb((Gc(),Fc),new u8b(this))};_.fe=function o8b(b,c){var d;if(gjb(c,this,b,true)){return}if('notStarted' in b[1]){db(this.q,400);return}if('forceSubmit' in b[1]){g8b(this);return}f8b(this,Boolean(b[1][Qsc]));this.b=c;this.j=b[1][Nrc];this.i=b[1]['nextid'];d=djb(c,b[1][Tsc][Lwc]);this.c.action=d;if(oAc in b[1]){bib(this.n,b[1][oAc]);this.n.Ob.style.display=Tpc}else{this.n.Ob.style.display=sqc}this.e.Ob.name=this.j+mAc;if(Erc in b[1]||Nsc in b[1]){b8b(this)}else if(!Boolean(b[1][dtc])){c8b(this);d8b(this)}};_.cM={10:1,13:1,15:1,17:1,19:1,20:1,21:1,22:1,26:1,33:1,69:1,70:1,75:1,76:1};_.b=null;_.c=null;_.d=true;_.f=false;_.i=0;_.j=null;_.n=null;_.o=false;_.p=null;_.q=null;_=q8b.prototype=p8b.prototype=new J;_.gC=function r8b(){return cG};_.lc=function s8b(b){this.b.f?(this.b.e.Ob.click(),undefined):g8b(this.b)};_.cM={12:1,39:1};_.b=null;_=u8b.prototype=t8b.prototype=new J;_.Zb=function v8b(){if(this.b.o){if(this.b.b){!!this.b.q&&cb(this.b.q);Mrb.Je('VUpload:Submit complete');$ib(this.b.b)}e8b(this.b);this.b.o=false;c8b(this.b);this.b.Kb||a8b(this.b)}};_.gC=function w8b(){return dG};_.cM={3:1,14:1};_.b=null;_=y8b.prototype=x8b.prototype=new $;_.gC=function z8b(){return eG};_.Vb=function A8b(){Mrb.Je('Visiting server to see if upload started event changed UI.');xib(this.b.b,this.b.j,'pollForStart',Tpc+this.b.i,true,105)};_.cM={65:1};_.b=null;_=C8b.prototype=B8b.prototype=new T2;_.gC=function D8b(){return fG};_.Vc=function E8b(b){Z$(this,b);if(CZ(b.type)==1024){this.b.f&&this.b.e.Ob.value!=null&&!zhc(Tpc,this.b.e.Ob.value)&&g8b(this.b)}else if((Umb(),!Tmb&&(Tmb=new qnb),Umb(),Tmb).b.i&&CZ(b.type)==2048){this.b.e.Ob.click();this.b.e.Ob.blur()}};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.b=null;var Hu=egc(Mxc,'AsyncLoader16'),jx=egc(Pxc,'FileUpload'),yx=egc(Pxc,'Hidden'),NA=egc(Wxc,'WidgetMapImpl$18$1'),cG=egc(Vxc,'VUpload$1'),dG=egc(Vxc,'VUpload$2'),eG=egc(Vxc,'VUpload$3'),fG=egc(Vxc,'VUpload$MyFileUpload');Ppc(yM)();