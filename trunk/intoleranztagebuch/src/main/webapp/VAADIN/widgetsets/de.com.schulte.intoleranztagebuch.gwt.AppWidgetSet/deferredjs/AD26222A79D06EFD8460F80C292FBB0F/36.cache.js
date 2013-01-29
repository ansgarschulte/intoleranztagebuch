function nT(){}
function iT(){}
function i4(){}
function v2(){}
function Tvb(){}
function Svb(){}
function S5b(){}
function u5b(){}
function K5b(){}
function O5b(){}
function W5b(){}
function L5b(b){this.b=b}
function P5b(b){this.b=b}
function T5b(b){bb();this.b=b}
function I5b(b,c){b.enctype=c;b.encoding=c}
function Nzb(b,c){b.onload=function(){c.Nf()}}
function w5b(b){wBb(b.n,false);b.o||(b.e.Lb[Koc]=true,undefined);b.d=false}
function x5b(b){wBb(b.n,true);b.e.Lb[Koc]=false;b.d=true;if(b.o){v5b(b);b.o=false}}
function v5b(b){if(b.p){$doc.body.removeChild(b.p);b.p.onload=null;b.p=null}}
function j4(){var b;this.Lb=(b=$doc.createElement(Ooc),b.type=Xoc,b)}
function X5b(b){var c;this.b=b;this.Lb=(c=$doc.createElement(Ooc),c.type='file',c);this.Lb[zoc]='gwt-FileUpload'}
function A5b(b,c){if(b.f!=c){b.f=c;if(b.f){H$(b.e,1024);H$(b.e,2048)}}r$(b.Lb,'v-upload-immediate',b.f)}
function z5b(b){h_(b.k,b.n);h_(b.k,b.e);b.e=new X5b(b);b.e.Lb.name=b.j+Jzc;b.e.Lb[Koc]=!b.d;g3(b.k,b.e);g3(b.k,b.n);b.f&&H$(b.e,1024)}
function pT(){lT=new nT;Ub((Sb(),Rb),36);!!$stats&&$stats(xc(Izc,dnc,-1,-1));lT.Jc();!!$stats&&$stats(xc(Izc,Zuc,-1,-1))}
function mT(){var b,c,d;while(jT){d=nb;jT=jT.b;!jT&&(kT=null);if(!d){(Isb(),Hsb).lg(JF,new Tvb);jkb()}else{try{(Isb(),Hsb).lg(JF,new Tvb);jkb()}catch(b){b=PI(b);if(mr(b,37)){c=b;cqb.xe(c)}else throw b}}}}
function B5b(b){if(b.e.Lb.value.length==0||b.o||!b.d){cqb.ze('Submit cancelled (disabled, no file or already submitted)');return}Ghb(b.b);b.c.submit();b.o=true;cqb.ze('Submitted form');w5b(b);b.q=new T5b(b);db(b.q,800)}
function y5b(b){var c;if(!b.p){c=$doc.createElement(Voc);c.innerHTML="<iframe src=\"javascript:''\" name='"+b.j+"_TGT_FRAME' style='position:absolute;width:0;height:0;border:0'>"||$mc;b.p=Sd(c);$doc.body.appendChild(b.p);b.c.target=b.j+'_TGT_FRAME';Nzb(b.p,b)}}
function C5b(){this.Lb=$doc.createElement('form');this.e=new X5b(this);this.k=new j3;this.g=new j4;this.c=this.Lb;I5b(this.Lb,Zwc);this.c.method='post';s1(this,this.k);g3(this.k,this.g);g3(this.k,this.e);this.n=new yBb;y$(this.n,new L5b(this),(rk(),rk(),qk));g3(this.k,this.n);this.Lb[zoc]='v-upload';this.Ib==-1?rZ(this.Lb,241|(this.Lb.__eventBits||0)):(this.Ib|=241)}
var Jzc='_file',Kzc='buttoncaption',Izc='runCallbacks36';_=nT.prototype=iT.prototype=new J;_.gC=function oT(){return Cv};_.Jc=function sT(){mT()};_.cM={};_=v2.prototype=new XZ;_.gC=function w2(){return Uw};_.Oc=function x2(b){C$(this,b)};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=j4.prototype=i4.prototype=new XZ;_.gC=function k4(){return hx};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=Tvb.prototype=Svb.prototype=new J;_.Ke=function Uvb(){return new C5b};_.gC=function Vvb(){return $A};_.cM={137:1};_=C5b.prototype=u5b.prototype=new p1;_.gC=function D5b(){return JF};_.ed=function E5b(){B$(this);!!this.b&&y5b(this)};_.Oc=function F5b(b){(bZ(b.type)&241)>0&&(Lrb(this.b.G,b,this,null),undefined);C$(this,b)};_.fd=function G5b(){D$(this);this.o||v5b(this)};_.Nf=function H5b(){Crb((Gc(),Fc),new P5b(this))};_.Yd=function J5b(b,c){var d;if(Ohb(c,this,b,true)){return}if('notStarted' in b[1]){db(this.q,400);return}if('forceSubmit' in b[1]){B5b(this);return}A5b(this,Boolean(b[1][Upc]));this.b=c;this.j=b[1][Soc];this.i=b[1]['nextid'];d=Lhb(c,b[1][Xpc][Btc]);this.c.action=d;if(Kzc in b[1]){this.n.c.textContent=b[1][Kzc]||$mc;this.n.Lb.style.display=$mc}else{this.n.Lb.style.display=tnc}this.e.Lb.name=this.j+Jzc;if(Koc in b[1]||Spc in b[1]){w5b(this)}else if(!Boolean(b[1][lqc])){x5b(this);y5b(this)}};_.cM={10:1,13:1,15:1,17:1,19:1,20:1,21:1,22:1,26:1,33:1,69:1,70:1,75:1,76:1};_.b=null;_.c=null;_.d=true;_.f=false;_.i=0;_.j=null;_.n=null;_.o=false;_.p=null;_.q=null;_=L5b.prototype=K5b.prototype=new J;_.gC=function M5b(){return FF};_.ec=function N5b(b){this.b.f?(this.b.e.Lb.click(),undefined):B5b(this.b)};_.cM={12:1,39:1};_.b=null;_=P5b.prototype=O5b.prototype=new J;_.Wb=function Q5b(){if(this.b.o){if(this.b.b){!!this.b.q&&cb(this.b.q);cqb.ze('VUpload:Submit complete');Ghb(this.b.b)}z5b(this.b);this.b.o=false;x5b(this.b);this.b.Hb||v5b(this.b)}};_.gC=function R5b(){return GF};_.cM={3:1,14:1};_.b=null;_=T5b.prototype=S5b.prototype=new $;_.gC=function U5b(){return HF};_.Sb=function V5b(){cqb.ze('Visiting server to see if upload started event changed UI.');ehb(this.b.b,this.b.j,'pollForStart',$mc+this.b.i,true,105)};_.cM={65:1};_.b=null;_=X5b.prototype=W5b.prototype=new v2;_.gC=function Y5b(){return IF};_.Oc=function Z5b(b){C$(this,b);if(bZ(b.type)==1024){this.b.f&&this.b.e.Lb.value!=null&&!Pec($mc,this.b.e.Lb.value)&&B5b(this.b)}else if((ulb(),!tlb&&(tlb=new Plb),ulb(),tlb).b.i&&bZ(b.type)==2048){this.b.e.Lb.click();this.b.e.Lb.blur()}};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.b=null;var Cv=udc(Kuc,'AsyncLoader36'),Uw=udc(Nuc,'FileUpload'),hx=udc(Nuc,'Hidden'),$A=udc(Uuc,'WidgetMapImpl$48$1'),FF=udc(Tuc,'VUpload$1'),GF=udc(Tuc,'VUpload$2'),HF=udc(Tuc,'VUpload$3'),IF=udc(Tuc,'VUpload$MyFileUpload');Wmc(pT)();