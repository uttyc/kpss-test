package com.example.atik.kpsstest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {


    Database db;
    Button geo, history, law, math, turkish;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        geo = (Button) findViewById(R.id.button_geo);
        history = (Button) findViewById(R.id.button_history);
        law = (Button) findViewById(R.id.button_law);
        math = (Button) findViewById(R.id.button_math);
        turkish = (Button) findViewById(R.id.button_turkish);
        geo.setOnClickListener(this);
        history.setOnClickListener(this);
        law.setOnClickListener(this);
        math.setOnClickListener(this);
        turkish.setOnClickListener(this);
        db = new Database(this);
        clearDatabase();
        populateDatabase();

    }

    public void addQuestion(Question question) {
        db = new Database(this);
        db.insertQuestion(question);
    }

    public void clearDatabase() {
        db = new Database(this);
        db.clearTable();
    }

    public void populateDatabase() {
        addQuestion(new Question(Database.DBHelper.HISTORY, "Aşağıdakilerden hangisi İslamiyetten önce, Türklerde ölen kişinin eşyalarıyla birlikte gömüldüğü mezara verilen addır?", "Yuğ", "Şad", "Kurgan", "Toy", "Tigin", Database.DBHelper.ANSWER_C));
        addQuestion(new Question(Database.DBHelper.HISTORY, "Aşağıdakilerden hangisi, Hunların neden olduğu Kavimler Göçü’nün sonuçlarından biri değildir?","Avrupa’nın etnik yapısının değişmesi", "Avrupa’da bir Hun Devleti kurulması", "Roma İmparatorluğu’nun bütünlüğünü ve üstünlüğünü yitirmesi", "Avrupa’da skolastik düşüncenin egemen olması", "Göktürk Devleti’nin yıkılması", Database.DBHelper.ANSWER_E));
        addQuestion(new Question(Database.DBHelper.HISTORY, "Cengiz Han’ın torunu Hülagu tarafından İran’da kurulan ve 1258 yılında Bağdat’ı alarak Abbasi Devleti’ne son veren devlet aşağıdakilerden hangisidir?", "İlhanlı Devleti", "Timur Devleti", "Altın Orda Devleti", "Çağatay Devleti", "Memluk Devleti", Database.DBHelper.ANSWER_A));
        addQuestion(new Question(Database.DBHelper.HISTORY, "Aşağıdakilerden hangisi, Türk-İslam devletlerinde pazarlarda fiyatları, tartı ve ölçü aletlerini, üretilen ve satılan malların kalitesini denetleyen görevlidir?","Ulak", "Silahtar", "İğdişbaşı", "Muhtesip", "Câmedâr", Database.DBHelper.ANSWER_D));
        addQuestion(new Question(Database.DBHelper.HISTORY, "Osmanlı Döneminde, Fatih Sultan Mehmet’in hocası olmuş, din, tasavvuf ve tıp alanlarındaki çalışmalarıyla bilinen ünlü bilgin aşağıdakilerden hangisidir? ","Ebussuud", "Emir Sultan", "Akşemseddin", "Kemalpaşazade", "Molla Fenari", Database.DBHelper.ANSWER_C));
        addQuestion(new Question(Database.DBHelper.GEOGRAPHY, "Türkiye’de 1950 yılından sonra etkili olmaya başlayan iç göçlerle ilgili olarak aşağıdakilerden hangisi söylenemez?","Denize kıyısı olan coğrafi bölgelerin tümünde nüfus artışının başlıca nedeni bölge dışından alınan göçlerdir.", "İç göçlerin önemli bir bölümü ekonomik ve sosyal alanlardaki değişimler ve doğal afetler gibi nedenlerle olmaktadır.", "Göç hareketi daha çok doğudan batıya doğru olmaktadır.", "Göç veren illerde doğum oranı genellikle yüksektir.", "Türkiye’de nüfus hareketlerinin büyük çoğunluğunu iç göçler oluşturmaktadır.", Database.DBHelper.ANSWER_A));
        addQuestion(new Question(Database.DBHelper.GEOGRAPHY, "Aşağıdakilerden hangisi Kocaeli, Bursa ve Sakarya illerinin ortak özellikleri arasında yer almaz?","Nüfus yoğunluklarının Türkiye ortalamasının üzerinde olması", "Ulaşım olanaklarının gelişmiş olması", "Petrokimya endüstrisinin gelişmiş olması", "Dışarıdan göç alması", "Aynı coğrafi bölgede topraklarının bulunması", Database.DBHelper.ANSWER_C));
        addQuestion(new Question(Database.DBHelper.GEOGRAPHY, "Güneydoğu Anadolu Projesi’nin hayata geçirilmesi, bu bölgede yoğun olarak yetiştirilen ürünlerden hangisinin üretim miktarının artmasında daha etkili olmuştur?","Antep fıstığı", "Kırmızı mercimek", "Pamuk", "Tütün", "Buğday", Database.DBHelper.ANSWER_C));
        addQuestion(new Question(Database.DBHelper.GEOGRAPHY, "Ege Bölgesi’nde kıyı boyunca kuzeyden güneye doğru turistik amaçlı gezi yapan bir grup, aşağıdakilerden hangisine rastlamaz?","Antik kentlere", "Millî parklara", "Yat limanlarına", "Kayak merkezlerine", "Kaplıcalara", Database.DBHelper.ANSWER_D));
        addQuestion(new Question(Database.DBHelper.GEOGRAPHY, "İzmir’in merkez ilçesine bağlı bir köye kara yoluyla ulaşabilmek için ortalama on kilometre yol almak gerekirken Kütahya’da kuş uçumu mesafesi aynı olan bir köye on beş kilometre yol almak gerekmektedir.\n" +
                "Bu durum, aşağıdakilerden hangisiyle açıklanabilir?","Yerleşme birimlerinin sıklığıyla", "Doğal bitki örtüsünün farklılığıyla", "İklim koşullarının farklılığıyla", "Tarım alanlarının genişliğiyle", "Yer şekillerinin engebeliğiyle", Database.DBHelper.ANSWER_E));
        addQuestion(new Question(Database.DBHelper.LAW, "1982 Anayasası’na göre, TBMM kaç milletvekilinden oluşur?","400", "450", "500", "550", "600", Database.DBHelper.ANSWER_D));
        addQuestion(new Question(Database.DBHelper.LAW, "1982 Anayasası’na göre, Devletin şekli ile ilgili aşağıdaki ifadelerden hangisi doğrudur?","Türkiye federal devlettir.", "Türkiye konfederal bir devlettir.", "Türkiye Devleti monarşidir.", "Türkiye Devleti totaliter bir devlettir.", "Türkiye Devleti bir Cumhuriyet’tir.", Database.DBHelper.ANSWER_E));
        addQuestion(new Question(Database.DBHelper.LAW, "Aşağıdaki idarelerden hangisi bir mahallî idare birimi değildir?","Yuva köyü", "Çukurambar Mahallesi", "Elmadağ Belediyesi", "Ankara İl Özel İdaresi", "Ankara Büyükşehir Belediyesi", Database.DBHelper.ANSWER_B));
        addQuestion(new Question(Database.DBHelper.LAW, "Köy işlerinin bütün köylü birleşerek yapılması usulüne ne ad verilir?","İmece", "Salma", "Dayanışma", "İstimval", "Fiilî yol", Database.DBHelper.ANSWER_A));
        addQuestion(new Question(Database.DBHelper.LAW, "Hakkında soruşturma açılan bir belediye başkanını geçici olarak görevden uzaklaştırma yetkisi aşağıdakilerden hangisine aittir?","Başbakan", "İçişleri Bakanı", "Vali", "Belediye meclisi", "Danıştay", Database.DBHelper.ANSWER_B));
        addQuestion(new Question(Database.DBHelper.TURKISH, "Aşağıdaki cümlelerin hangisinde bir işin sürekli olarak yapıldığı anlamı vardır?","Bu hafta ders çalışmaya daha çok zaman ayırıyor.", "Karlı yolda arkadaşıma tutunmasaydım düşecektim.", "Böyle davranmaya devam ederse hakem onu oyundan çıkarıverir.", "Babamın anlattıklarına gülmemek için kendimi zor tuttum.", "Şirketimizde bu kararlar yıllardır uygulanagelmekte", Database.DBHelper.ANSWER_E));
        addQuestion(new Question(Database.DBHelper.TURKISH, "Dergiler ve gazeteler hızla güncelliğini yitiriyor. Bu nedenle ben, kalıcı olsun diye, çizdiklerimi bir araya getirmek istiyorum. Çünkü onlar tekrar tekrar bakılacak karikatürler. Ben de ünlü bir karikatürist arkadaşımın on yıl önce çıkarttığı kitapta yer alan karikatürlere hâlâ gülüyorum. On yıl sonra da güleceğim.\n" +
                "Bu sözler aşağıdaki sorulardan hangisine karşılık olarak söylenmiş olabilir?","Konularınızı hep günlük olaylardan mı seçersiniz?", "Bir karikatürist olarak çizdiklerinizi neden bir kitapta toplamayı düşünüyorsunuz?", "Sizce karikatürde çizgi mi, söz mü daha önemli?", "Karikatürlerinizi ilginç kılan özellikler nelerdir?", "Sizce karikatürün amacı güldürmek midir?", Database.DBHelper.ANSWER_B));
        addQuestion(new Question(Database.DBHelper.TURKISH, "Ülkemizde çok iyi oyuncular var ama ne yazık ki bunlar yabancı dile gereken önemi vermiyorlar. Ana dilleri gibi Fransızca ve İngilizce bilseler yabancı ülkelerdeki oyuncuları bile gölgede bırakırlar.\n" +
                "Bu parçada geçen “gölgede bırakmak” sözüyle anlatılmak istenen aşağıdakilerden hangisidir?","Başkalarından üstün duruma gelmek", "Eğitim yoluyla kendini geliştirmek", "Çağın gereklerine uymak", "Yeni oyun teknikleri geliştirmek", "Bilgi dağarcığını zenginleştirmek", Database.DBHelper.ANSWER_A));
        addQuestion(new Question(Database.DBHelper.TURKISH, "Aşağıdaki cümlelerden hangisi, ayraç içinde verilenlerle uyuşmamaktadır?","Benim müziğe yaklaşımım, çevremdeki müzisyenlerin çoğunun benimsediği bu akımla örtüşmüyor (karşılaştırma).", "Onun hangi albümünü alırsanız alın, niteliksizlikle, özensizlikle ya da düzeysizlikle karşılaşmayacağınızdan emin olabilirsiniz (nesnellik).", "Ülkemizde yetişmiş piyanistlerin bir kısmı, ilk albümlerinin repertuvarında gösterdikleri başarıyı sonrakilerde gösteremiyor (saptama).", "Son albümlerindeki başarısızlıkları, önceki çalışmalarında kazandıkları başarıdan dolayı duydukları aşırı öz güvenden kaynaklanmış olabilir (tahmin).", "Türkiye’de dünyaca ünlü piyanistlerin yetişmiş olması, sanatımızın gelecek vadettiğini gösteriyor (çıkarım).", Database.DBHelper.ANSWER_B));
        addQuestion(new Question(Database.DBHelper.TURKISH, "Aşağıdaki cümlelerin hangisinde, ayraçlarla belirtilen yerlere ötekilerden farklı bir noktalama işareti konulmalıdır?","Buraya yerleşince ev almışlar, büyükbaş hayvan almışlar ( ) ipek böcekçiliği, dokumacılık yapmışlar.", "Kabadayı ( ) şımarık bir delikanlı on sekiz yaşındaki dayımla tartışmış.", "Ailece aldıkları karar, hiç yılmamak, teslim olmamak ( ) sonuna kadar direnmekmiş.", "Yaşar Bey’in kiraladığı üç katlı ( ) her katında ikişer oda bulunan teraslı eve yerleşmişler.", "Sabah erkenden kalkıyor ( ) dükkânı açıp ortalığı topluyormuş.", Database.DBHelper.ANSWER_A));
        addQuestion(new Question(Database.DBHelper.MATH, "İki basamaklı AB sayısı 4 ile tam olarak bölünebilmekte ve 10 ile bölündüğünde 2 kalanını vermektedir.\n" +
                "Buna göre, A + B toplamı kaç farklı değer alabilir?","4", "5", "6", "7", "8", Database.DBHelper.ANSWER_B));
        addQuestion(new Question(Database.DBHelper.MATH, "(2x + 1)2 ≤ 9 eşitsizliğini sağlayan x tam sayı değerlerinin toplamı kaçtır?","-3", "-2", "-1", "2", "3", Database.DBHelper.ANSWER_B));
        addQuestion(new Question(Database.DBHelper.MATH, "Bir depodaki suyun önce % 30'u, sonra da kalanın % 20'si kullanıldığında depoda 42 litre su kalıyor.\n" +
                "Buna göre, ilk durumda depodaki su kaç litredir?","55", "60", "65", "70", "75", Database.DBHelper.ANSWER_E));
        addQuestion(new Question(Database.DBHelper.MATH, "Bir turizm şirketi, 1140 yolcu kapasiteli bir taşıma filosu kurmak için 18, 24 ve 42 yolcu kapasiteli araçların her birinden en az bir tane olmak üzere toplam 30 adet satın almak istiyor.\n" +
                "Buna göre, 42 yolcu kapasiteli araçtan kaç tane almalıdır?","20", "21", "22", "23", "24", Database.DBHelper.ANSWER_E));
        addQuestion(new Question(Database.DBHelper.MATH, "Bir çalışan, maaşına yapılan 40 TL zam yerine daha yüksek olan % 6 oranındaki zammı tercih etmiştir." +
                "Bu çalışanın zamsız maaşı aşağıdakilerden hangisi olabilir?","680", "650", "620", "540", "480", Database.DBHelper.ANSWER_A));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_history:
                Intent history = new Intent(this, HistoryActivity.class);
                startActivity(history);
                break;
            case R.id.button_geo:
                Intent geo = new Intent(this, GeoActivity.class);
                startActivity(geo);
                break;
            case R.id.button_law:
                Intent law = new Intent(this, LawActivity.class);
                startActivity(law);
                break;
            case R.id.button_turkish:
                Intent turkish = new Intent(this, TurkishActivity.class);
                startActivity(turkish);
                break;
            case R.id.button_math:
                Intent math = new Intent(this, MathActivity.class);
                startActivity(math);
                break;
        }
    }
}