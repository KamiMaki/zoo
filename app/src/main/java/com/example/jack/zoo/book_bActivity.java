package com.example.jack.zoo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class book_bActivity extends AppCompatActivity {

    Button bt;
    TextView tv1,tv2,tv3,tv4;
    ImageView img;
    boolean reserve[]=new boolean[20];
    String title[]=new String[20];
    String writer[]=new String[20];
    String publisher[]=new String[20];
    String summary[]=new String[20];
    Intent intent=new Intent();
    Bundle bundle=new Bundle();
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_b);

        intent = this.getIntent();
        bundle = intent.getExtras();
        tv1=findViewById(R.id.textView27);//書名
        tv2=findViewById(R.id.textView28);//作者
        tv3=findViewById(R.id.textView29);//出版社
        tv4=findViewById(R.id.textView26);//大意
        bt=findViewById(R.id.button);
        img=findViewById(R.id.imageView6);

        title[0]="動物遊樂園:\n動物行為的豐富化";
        title[1]="我只想回到自己的家:\n動物保護.生態關懷文選";
        title[2]="創意著色動物畫冊:\n輕鬆歡樂來塗鴉!";
        title[3]="字母動物園";
        title[4]="為什麼長這樣?\n25個Q&A,認識動物奇妙的臉";
        title[5]="爺爺的不可思議動物園";
        title[6]="牠鄉何處?:\n城市.動物與文學";
        title[7]="來幫動物量身高";
        title[8]="動物也瘋狂:\n動物精神創傷與復元的故事";
        title[9]="10個動物冒險:繪本故事";
        title[10]="動物的毛毛";
        title[11]="動物國的流浪者";
        title[12]="動物王國向前衝：3D AR擴增實境APP互動遊戲書";
        title[13]="動物很有事";
        title[14]="人體與動物結構特輯";
        title[15]="博物學家的神祕動物圖鑑";
        title[16]="好棒的水生動物";
        title[17]="動物博物館";
        title[18]="遇到危險動物時的求生秘技";
        title[19]="昨日之蛇 : 洛夫動物詩集";

        writer[0]="鄭世嘉, 潘玉潔";
        writer[1]="陳幸蕙主編";
        writer[2]="瓦倫蒂娜.哈珀(Valentina Harper)著 ; 黃春華譯";
        writer[3]="Cindy Wang";
        writer[4]="史提夫.詹金斯(Steve Jenkins), 蘿蘋.佩姬(Robin Page)著 ; 王心瑩譯";
        writer[5]="西岡Riki文圖 ; 張東君譯";
        writer[6]="黃宗潔";
        writer[7]="慶太郎文 ; 高畠純圖 ; 黃惠綺譯";
        writer[8]="蘿瑞兒.布萊特曼(Laurel Braitman)著 ; 蘇文君譯";
        writer[9]="瑪莉.特奈列等著 ; 賽西.于德希等繪 ; 徐也恬譯";
        writer[10]="Newtonkids新小牛頓雜誌企畫編輯";
        writer[11]="鄧紫云(兜兜)";
        writer[12]="幼福編輯部編";
        writer[13]="茱莉.戈隆貝(Julie Colombet)著 ; 陳怡潔譯";
        writer[14]="黃更, 楊錦程譯";
        writer[15]="(法)讓-巴普蒂斯特.德.帕納菲厄(Jean-Baptiste de Panafieu)作 ; 樊豔梅譯";
        writer[16]="邱貢(Chorkung)圖 ; 李紫蓉譯";
        writer[17]="珍妮.布魯姆(Jenny Broom)文 ; 凱蒂.史考特(Katie Scott)圖 ; 王心瑩譯";
        writer[18]="今泉忠明監修.著 ; 賴惠鈴翻譯";
        writer[19]="洛夫";

        publisher[0]="台北市立動物園";
        publisher[1]="幼獅文化";
        publisher[2]="生命潛能文化";
        publisher[3]="田園城市文化";
        publisher[4]="遠流文化";
        publisher[5]="青林國際";
        publisher[6]="新學林";
        publisher[7]="維京國際";
        publisher[8]="網路與書";
        publisher[9]="東雨文化";
        publisher[10]="康軒文教";
        publisher[11]="啟動文化";
        publisher[12]="幼福文化";
        publisher[13]="字畝文化";
        publisher[14]="新一代圖書";
        publisher[15]="楓樹林";
        publisher[16]="上人文化";
        publisher[17]="大家";
        publisher[18]="人人";
        publisher[19]="遠景";

        summary[0]="        動物園推動「行為豐富化」，透過改變動物的圈養環境，或是增加飼養管理的操作變化， 來誘發或增加動物表現自然行為的機會，其出發點在於提升動物福祉、促進動物的健康。本書以圖文介紹臺北動物園多年來實行的「行為豐富化」措施，讓讀者在觀賞可愛的動物之餘，也能獲得動物照養及動物行為學的相關知識。";
        summary[1]="        身為人類，面對地球上的萬物生靈，是驕傲？是慚愧？當生態環境遭人為破壞，大量物種瀕臨滅絕時，我們難道只能說「生而為人，我很抱歉」？\n\n        當社會一再發生虐殺動物事件時，大眾常感震驚：為何人性竟如此殘忍？怎能視傷害生命為樂呢？我們的教育到底出了什麼問題？\n\n" +
                "        本書是作家陳幸蕙有感於社會的需求，以「動物保護、生態關懷」為主題而編的散文選，囊括鄭板橋、豐子愷、余光中、紀弦、琦君、黃永武、黃碧端、南方朔、奚淞、顏崑陽、林清玄、陳幸蕙、劉克襄、廖鴻基、田威寧、劉詩媛等不同世代作家的精采之作，有從悲憫的角度書寫動物受苦的形象，也有人本中心主義的反省、對動物權的思考，及共享地球資源的倫理觀等面向。\n\n"+
                "        地球是萬物生靈共同的家，期待這本充滿關懷意識的選集，喚起大眾更加珍視萬物、尊重生命，讓地球上的微塵眾生，在和諧共處的家園中，歡喜自在！\n\n" +
                "        每篇文末附賞析，提供讀者深入品味文章的精妙，進而提升寫作力。\n\n*適讀年齡：國、高中";
        summary[2]="　　本書內含三十幅著色畫稿，將帶你進入充滿喜悅的動物夢想世界。從貓頭鷹和大象，到孔雀與穿山甲，這群優雅的動物以豐富細緻的線條栩栩如生展現，你可能需要花好幾個小時才能畫完一頁！\n\n" +
                "　　不需具備藝術家的複雜技巧，也能利用這些細緻的圖稿輕鬆畫出個人風格的作品。天才藝術家瓦倫蒂娜‧哈珀在書中提供了獨特的著色小技巧，簡單易學，讓你輕鬆上手，還有暢銷工藝家瑪麗‧勃朗寧（Marie Browning）提供美麗的著色範例，為本書增添無比樂趣。本書特別選用厚紙印刷，不易透色。無論你使用麥克筆、中性筆、水彩、或是色鉛筆，這本著色書都能讓你輕鬆紓壓，創造喜悅好心情！";
        summary[3]="-文字的新造型藝術，重組與解構字母的趣味動物園！\n" +"-一本關於Expressive Typography Design 的書。\n\n" +
                "       最有趣的地方之一，在於將文字轉化為視覺圖像與插畫元素，重新解構和設計編排，呈現出文字多元且多變的趣味點。並藉由字母與幾何線條、色塊、點線之間的設計對話，開展出一種新鮮的視覺探索！\n\n" +
                "       書裡出現的二十六種動物造型，都只能運用在動物英文單字中出現的字母來組合和表現。也就是說，熊（bear）只可以用這四個字母的大寫和小寫，即B、E、A、R和b、e、a、r的組合排列來設計，並希望在構成動物造型時，能有趣、獨特、有風格。也依照動物的獨特個性和特質為基礎，書寫了簡單而具深意的文字。\n\n" +
                "       作者利用文字間互相的巧妙結合，呈現出有個性、特徵、視覺強烈而有力的動物造型。書中描繪的主題包括了抽象的色塊、由字母組成的幾何圖形、故意以圖像式編排的英文字母等等，希望能把文字豐富、多元而多變的迷人風貌呈現出來。在色彩運用方面，大多採用黑白強烈的對比色系，以帶出具有童趣的藝術風格。整體設計上，則以圖文交融的方式，讓文字變成圖像的一部分，希望能讓文字與圖像兩者協調地並置於畫面之中，達到形式與內容的細膩融合。";
        summary[4]="長頸鹿的舌頭為什麼是紫色？\n河豚為什麼會膨脹成一顆球？\n角鵰頭上的羽毛為什麼會一根根豎起來？ \n\n" +
                "       牠們可不是無緣無故長成這個樣子喔，其實這些奇妙特徵的存在，都有它們超級重要的理由，不過這不是我們人類說了就算！\n\n" +
                "　　本書集合了25種非常獨特的動物，牠們將親口揭露自己奇特樣貌背後的大祕密。透過這些動物的現身說法，你會對牠們的身體特徵與功能更加了解！" ;
        summary[5]="　　歡迎光臨不可思議動物園！\n" +
                "　　咦，這裡面的動物怎麼都長得歪七扭八的，不像是正常的動物啊！\n" +
                "　　別懷疑，進入這個奇妙的動物園，還得透過神奇的魔鏡，才能看到這些奇妙的動物呢！\n\n" +
                "　　小男孩在某個晴朗的日子裡，遇到了一位奇妙的老爺爺。老爺爺有個神奇魔鏡，可以讓人到奇妙動物園去，小男孩跟著老爺爺一起去一探究竟。在那裡，他看到了好多好特別的動物，不過他們都因為人類或環境因素而從地球上消失了……";
        summary[6]="　　本書結合文本分析、時事評論、倫理思考，並藉由文學與藝術作品中看待動物的各種角度，探討人與環境、人與自然、人與他者之間糾結錯綜的關係。\n\n" +
                "　　書名「牠鄉何處」，正在於凸顯此一觀點：被邊緣化的動物們不得其所的命運若要有所改變，有待更多人了解，無論我們如何在心理上與實際空間上試圖劃界排除，人與動物都生活在同樣的場域。\n\n" +
                "　　因此，書寫動物，就是書寫人類自身，是理解人與自然命運的途徑。";
        summary[7]="　　這是一本實際走訪動物園的趣味「測量之書」，本書量測的不只是數據，更是樂趣。量身高、體重是我們習以為常的事。對於動物呢？幫動物量身高和體重的時候，又會發生什麼意想不到的事呢？作者實地前往動物園測量，以樂趣十足的方式，把他的觀察結果分享給各位讀者！";
        summary[8]="　　一隻患有重度社交恐懼症的倭黑猩猩，是如何復元並成為群族領䄂？\n" +
                "　　吃好、住好，被疼愛的伯恩山犬為何要跳窗「自殺」？\n" +
                "　　是什麼觸發大象泰克要殺人？曾被漁夫捕殺的「惡魔魚」灰鯨又為何主動接近人類討摸？\n\n" +
                "　　在這個動物星球上，我們與其他動物之間，往往存在著一個赤裸裸、令人內疚的國度，而且那個國度非常擁擠。許多人都在那裡尋找解答、自責，想著我們當初如果能做些什麼，牠們的生活品質就能得到改善，或者就能保住牠們的生命，一切就會不一樣。達爾文的父親曾告訴他：「健全與錯亂的人之間，存在著一個完美漸層⋯⋯每個人在某些時刻都是神智不清的。」人類是如此，其他生物亦然。而從牠們瘋狂的行徑中，我們也能夠認清，這些事件反映的其實是我們各種不健康的習慣。\n\n" +
                "　　我們在生活中給這些生物帶來了許多不必要的痛苦，而且是可以輕易被去除的，例如我們可以不要再教大象畫畫、跳舞，還有踢足球，也可以不要再讓猩猩演廣告；我們可以不要再欺騙自己，認為在城市看到大猩猩、海豚以及大象，這些異域野生動物是我們的權利。我們也可以不要再說服自己，說把動物關在籠子或水槽裡是教育大眾與學習動物知識的最佳途徑，尤其是當這麼做往往害動物發瘋的話⋯⋯";
        summary[9]="10 篇你絕對沒看過的有趣動物故事，\n搭配法式的夢幻繪圖風格，\n以及創意十足的童謠＆遊戲，\n跟著書中的角色一起冒險同時，\n也能學習文字聲音的韻律之美，\n並培養手作的能力，\n更深刻的和故事情節作互動連結，\n讓孩子的閱讀世界樂趣滿滿！";
        summary[10]="       《動物的毛毛》從介紹動物身上的毛開始，引導幼兒觀察動物毛毛的外形與功能，並思考自己配合氣候時的衣著方式。也認識自身臉上的毛髮，並利用自己的頭髮和動物毛毛做成的毛線，操作生活中經常遇到的「靜電」現象，書中提供科學材料，可用QR code掃描後透過影片說明，利用簡易有趣的科學活動，進行潛移默化的學習。";
        summary[11]="親愛的動物們，\n我們都只是人類，我們也是動物，\n我們和你們一樣都還在成長與演化。\n請原諒我們還在摸索，還沒找到最溫柔的方式，還有太多的問題。\n請相信這個世界會越來越好的。\n\n" +
                "　　雲門舞集流浪者計畫第十屆得主鄧紫云，旅行地點是印度，計畫是「前往法律明文禁止流浪動物安樂死的印度，記錄人與動物的相處情景；並深入伊斯蘭教區，實地觀察符合人道的食用動物屠宰程序」。\n\n" +
                "　　在台灣，還有許多所謂的先進國家，伴侶動物住在家裡，經濟動物在已稱不上農場的擁擠屋舍，圈養野生動物在動物園、海洋公園、休閒農場、有錢人的後院，實驗動物住在實驗室，流浪動物們沒有人類所認可的家，城市是人類的，動物沒有爭辯的餘地。\n" +
                "　　這些動物，真的還是動物嗎？\n\n" +
                "　　以流浪為名、以動物為題的旅行，鄧紫云踏上印度大陸這塊土地，要探究的除了流浪本身，還有重新檢視人與動物的關係，不純然是我們現在比較喜愛討論的與伴侶動物的那種關係，而是人與動物共存的關係，人食用動物的關係；以及，人與大地母親的關係。";
        summary[12]="　　打開書本就能馬上看到世界各地的動物們在你面前出現！你知道草原上最凶猛的動物是誰嗎？原來不是每一隻鸚鵡都想開口說話？走起路來搖搖擺擺的企鵝，原來是一種鳥類呢！還有、還有，身高最高的動物－長頸鹿，居然會張開眼睛睡覺！感受動物王國裡的奧秘與活力，還能和牠們一起合照喔！\n\n" +
                "　　本書使用最新的擴增實境技術，生動的動物王國就會近距離地在孩子面前呈現！\n" +
                "　　下載專屬的免費APP，透過手機或是平板電腦的攝影鏡頭，對準書上的動物們，就能在螢幕上看見牠們自在地活動，讓孩子感覺好像自己真的進入動物王國裡，增加孩子主動學習的動機。\n\n" +
                "　　用畫面上的照相功能，還能讓孩子與書上的動物們一起拍照呢！\n" +
                "　　用3D擴增實境互動APP和全世界的動物們一起好好探索吧！\n" +
                "　　APP搜尋關鍵字：3DAR Animal";
        summary[13]="在動物園裡、電視節目上，我們每天都看到好多動物。\n但是，我們真的瞭解這些動物嗎？\n\n" +
                "八隻棕熊排排站，才跟巨烏賊一樣長！\n抹香鯨的頭，和三隻大象加起來誰比較重？\n大食蟻獸每天要吃多少隻螞蟻？\n沙漠跳鼠可以三年不喝半滴水！\n\n" +
                "　　只要換個角度看動物，就可以發現平常想都想不到的神奇祕密……";
        summary[14]="　　本書為人體與動物結構1、2二書的精華特輯，第1輯(人體與動物結構)中正確的解剖學基礎知識與國際最優秀的畫家與讀者分向繪製人體、動物的必備技巧。第2輯(人體動態結構)解釋人的身體如何運動，將人體結構拆解成簡單的形狀，並透過韻律線連接畫出動態的身體。";
        summary[15]="       在一個認知尚淺、居民尚少的世界，一切皆有可能──至少一切都似是而非。\n" +
                "　　不為人所知的巨獸、讓人吃驚的各種變形、從不同生物——甚至人類身上——借來的各個部分組合而成的動物。\n" +
                "　　男神、女神、牧神、山神、諸多森林與水流中的神祇，一直在催生新的造物。\n" +
                "　　旅行者反覆講述著侏儒、獨角獸與巨鷹的古老故事，\n" +
                "　　豐富著它們的內容，最終這些故事都成了一些平淡的事實。\n\n" +
                "　　1959年，神祕動物學擠進了「科學」的範疇，\n" +
                "　　人們試圖將神祕動物與已知動物進行對比，證明牠們的可信性，\n" +
                "　　但也有學者對其中某些動物的存在表示懷疑。\n" +
                "　　如普林尼就不相信有美人魚、飛馬，\n" +
                "　　但他又不無委婉地說道：「在真正出現以前，有多少東西是不可想像的。」\n\n" +
                "　　人們遊走在虛實之間，有些曾經存在的化作傳說，而宇宙同時又有新的創生，\n" +
                "　　但透過短暫的歷史，我們謙卑也自負的證實，想像終將比可見的真實走得更遠。\n" +
                "　　也許未來有一天，我們的後代也會弄明白這份名錄究竟是一場夢境，爾或真實的預言。";
        summary[16]="       推一推，轉一轉，\n　　一起來認識生長在珊瑚礁、\n　　岩池和冰山的水生動物，\n　　探索奇妙的水中世界！";
        summary[17]="　　這是一座自然史博物館，從嬌小的昆蟲，到巨大的藍鯨，全都以驚人的細節呈現在你眼前。\n\n" +
                "　　在這裡，你可以看到生命如何從海洋中簡單的海綿動物，演變成今日地球上可以找到的各式野生動物！\n\n" +
                "　　你可以進入解剖室，深入研究動物的骨骼和內臟！\n\n" +
                "　　你還可以觀察到氣候如何影響生態系統，了解到物種經過數百萬年的演化，最後如何適應牠們的生存環境！\n\n" +
                "　　無脊椎動物、魚類、兩生類、爬行類、鳥類和哺乳類，這些動物有古有今，有大有小，有凶猛也有柔弱的。\n\n" +
                "　　你會在這裡，見識到成果輝煌的動物王國！";
        summary[18]="　　如果有一天，在野外遇見危險動物該怎麼辦呢？今天就讓這本「遇到危險動物時的求生秘技」教你如何逃出生天。\n" +
                "\n" +
                "　　以「萬一遇到危險動物的時候該如何自保？該如何從危險動物口下保住一命？」的角度出發，搭配漫畫式的插圖，以輕鬆幽默、深入淺出的方式來介紹各種危險動物的特徵、攻擊力、攻擊方法等等，是有助於我們了解危險動物的科學小百科，小孩、大人都能看得津津有味！像是遇到虎頭蜂的時候千萬不要尖叫逃跑，最好當場蹲下來，一動也不動，即使虎頭蜂停在身體上，也要忍耐，絕對不能動，虎頭蜂盤旋一陣就會飛走。最後還介紹去野外的時候要帶些什麼東西、穿成什麼樣子，要是真的受傷又該如何急救。萬一有天真的在荒郊野外遇到這些危險動物，從這本書裡所學到的知識或許真能救自己及同行的人一命也說不定。\n" +
                "\n" +
                "　　除了野生動物之外，書末另外介紹了潛藏在居家的危險動物、前往野外的裝備和穿著、急救措施等精彩單元，讓讀者全面了解各種危險動物相關知識。此外，這本書的中文版審訂者請到任職於國立臺灣科學教育館的劉藍玉博士。在圖文並茂的輕鬆之餘也不失正確性及專業性。不論大人小孩，如果想要了解危險動物，本書絕對是你的好選擇。";
        summary[19]="　　在《魔歌》詩集的自序中，洛夫曾言：「真我，是一個詩人唯一追求的目標。要想達到此企圖，詩人首先必須把自身割成碎片，而後揉入一切事物之中，使個人的生命與天地之間的生命融為一體。」這部《昨日之蛇》即是詩人這段「物我同一」自白的具體體現。\n" +
                "\n" +
                "　　《昨日之蛇》收錄41首書寫動物的作品，詩人體認到人與動物都是宇宙之神賦予的一個生命、一種自然的存在，彼此之間的應對與聯繫，使他從各種小動物的生態演變之觀察，發掘出人和動物的互動關係，進而以象徵手法與詩筆細膩地描繪出人與其心智站立於天地的姿態。這部動物詩集並非返老還童的童詩，而是詩人觀看自我一生的一面明鏡，明鏡中所照耀出的是，詩人矗立於生命高峰上的一段見證。";

        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[number]==false) {
                    bt.setText("取消預約");
                    reserve[number]=true;
                    new AlertDialog.Builder(book_bActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt.setText("預約借書");
                    reserve[number]=false;
                    new AlertDialog.Builder(book_bActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        Thread t1 = new Thread(r1);
        t1.start();
    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
                number = bundle.getInt("number");
            } catch (Exception e) {
                Log.e("Net", "Fail to put");
            }
            Message message = new Message();
            message.what = 1;
            h1.sendMessage(message);
        }
    };

    Handler h1 = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                tv1.setText(title[number]);
                tv2.setText(writer[number]);
                tv3.setText(publisher[number]);
                tv4.setText(summary[number]);
                if(number==0) {
                    img.setImageResource(R.drawable.book1);
                }
                else if(number==1) {
                    img.setImageResource(R.drawable.book2);
                }
                else if(number==2) {
                    img.setImageResource(R.drawable.book3);
                }
                else if(number==3) {
                    img.setImageResource(R.drawable.book4);
                }
                else if(number==4) {
                    img.setImageResource(R.drawable.book5);
                }
                else if(number==5) {
                    img.setImageResource(R.drawable.book6);
                }
                else if(number==6) {
                    img.setImageResource(R.drawable.book7);
                }
                else if(number==7) {
                    img.setImageResource(R.drawable.book8);
                }
                else if(number==8) {
                    img.setImageResource(R.drawable.book9);
                }
                else if(number==9) {
                    img.setImageResource(R.drawable.book10);
                }
                else if(number==10) {
                    img.setImageResource(R.drawable.book11);
                }
                else if(number==11) {
                    img.setImageResource(R.drawable.book12);
                }
                else if(number==12) {
                    img.setImageResource(R.drawable.book13);
                }
                else if(number==13) {
                    img.setImageResource(R.drawable.book14);
                }
                else if(number==14) {
                    img.setImageResource(R.drawable.book15);
                }
                else if(number==15) {
                    img.setImageResource(R.drawable.book16);
                }
                else if(number==16) {
                    img.setImageResource(R.drawable.book17);
                }
                else if(number==17) {
                    img.setImageResource(R.drawable.book18);
                }
                else if(number==18) {
                    img.setImageResource(R.drawable.book19);
                }
                else if(number==19) {
                    img.setImageResource(R.drawable.book20);
                }
                setResult(RESULT_OK,intent);
            }
        }
    };
}
