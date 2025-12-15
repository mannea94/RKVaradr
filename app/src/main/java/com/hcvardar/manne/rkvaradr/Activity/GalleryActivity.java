package com.hcvardar.manne.rkvaradr.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.Adapter.GalleryAdapter;
import com.hcvardar.manne.rkvaradr.Model.ImageModel;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.RecyclerItemClickListener;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;




    ArrayList<ImageModel> data = new ArrayList<>();

    public static String IMGS[] = {
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61835436_10158140476605348_2715736172339920896_n.jpg?_nc_cat=111&_nc_oc=AQm9oE35LmfjkOvrZ23H4AiP73wrtLHjRNZgijyOoMEB5E03RQfos6CFlSchm9U_lv8&_nc_ht=scontent.fskp3-1.fna&oh=4d9ee68e6c1da6185d5af15928e7131b&oe=5DC71515",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61922482_10158140476490348_1514920263349698560_n.jpg?_nc_cat=111&_nc_oc=AQn7QSCe7ClYqjCA6NR6FVHzismZO4gYwOosERzSYJ-96Y7pNKH-HHc0gPhT1fB5GHc&_nc_ht=scontent.fskp3-1.fna&oh=39be5ed0ec6d980134c8546c9321451f&oe=5DB999D2",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61665007_10158140476865348_5946641637336678400_n.jpg?_nc_cat=109&_nc_oc=AQlyh6dvmLdNsZ2Zh6ZYlGeLFGUptRHHBXhYt6E-NQVDzBXz5u8l_M-FYlAzb-663XY&_nc_ht=scontent.fskp3-1.fna&oh=27e587fd06b16ce7e1369d9a180a3aed&oe=5D78F5CF",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61843734_10158140476890348_1248925358091141120_n.jpg?_nc_cat=104&_nc_oc=AQnH5Oj7M3m5H09jVQv-FbTE0D7UroyYNgAs2PchQxt_cvhB-JEeaBCuUDgF54oNuys&_nc_ht=scontent.fskp3-1.fna&oh=9bb457f24f85b9925de094f6f6c13ced&oe=5D80ECEA",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62100352_10158140477055348_488036244786249728_n.jpg?_nc_cat=111&_nc_oc=AQmlowgejM1EiRH1AplBq8fhjnGyWa8-URY_ewbdHSlr-tC-RR-EVYJ9X5HL6ezZWoY&_nc_ht=scontent.fskp3-1.fna&oh=c51fb52df17d4054dc61b597257390a6&oe=5DBAE237",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62141001_10158140477085348_2821688162219196416_n.jpg?_nc_cat=103&_nc_oc=AQnhEHoTwjF5tqo7SgHESfP34966evlQBhrlHIaj8PPvJtOinR8Cno7PK_B_FRSufiY&_nc_ht=scontent.fskp3-1.fna&oh=372a94b0442683f67fd9c3130b8ba74e&oe=5DC17809",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62172777_10158140477105348_9135887530174971904_n.jpg?_nc_cat=107&_nc_oc=AQkNUiUaE1Fw4jrXai7_ZsKMkoeFgDWY7x6NDqYvg7C7ytVk8rst-SmZuajh1_5XTKs&_nc_ht=scontent.fskp3-1.fna&oh=10f9f30583864683d34371ae7bb85b74&oe=5DB3C13D",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61761774_10158140477230348_3195813481949429760_n.jpg?_nc_cat=107&_nc_oc=AQkf4_ucdJZpl35TxQIg2ROu8I3Nt_wP2oiWTG3yoLFn60lUN7uBREuepcy-MqZhzSg&_nc_ht=scontent.fskp3-1.fna&oh=bee1bd63d4028c6e33db912aad21c0fd&oe=5DBECB4E",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61998717_10158140477280348_1673047816588492800_n.jpg?_nc_cat=111&_nc_oc=AQn5Uc9SqQ1uAezF-t6gFXbLOPGLsg3vNNXCqe9asIyczcgzniUD9YJBtcgnWGKjXoU&_nc_ht=scontent.fskp3-1.fna&oh=0b1ffc23f5ab4d06c6103d09fc5890da&oe=5DB37E4F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61898841_10158140477690348_6206628656442245120_n.jpg?_nc_cat=106&_nc_oc=AQmBTdgCpmtGyTk2Pnu0IgfgQQ9HObjmUd6Q_EsAGCLsD1CzKJgiRDkbHXoCaVC6dQs&_nc_ht=scontent.fskp3-1.fna&oh=fb324bcac043691055b20ac62259174d&oe=5DBD8878",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61817956_10158140478000348_8122380771370467328_n.jpg?_nc_cat=106&_nc_oc=AQmf0g6hErhhNvyrbAtbD2W6G9tjcH3afY1mJqtxALu3Wi2_UZ5Ex-fm6g9mVYNerpQ&_nc_ht=scontent.fskp3-1.fna&oh=2f4b1f765d89a210c95ea4ab943a273d&oe=5D7B5A4F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62019796_10158140478390348_739545638399639552_n.jpg?_nc_cat=108&_nc_oc=AQkJNu9iCZyoNp_kAQvwwpjVPS425kiqvLt3cgxaRBk9fXGsaVA6yisddQJmbz_EZ0I&_nc_ht=scontent.fskp3-1.fna&oh=51894e23a822a5ad0da3b7e11d91f20c&oe=5DB9C8E4",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61975489_10158140478725348_7160683155085590528_n.jpg?_nc_cat=109&_nc_oc=AQkI52qCE38_Lzcwb6vIa9r2Q6yv_N4a8ODql8jQ3YzeaAeBqPkIgUMcEt1bevVov-4&_nc_ht=scontent.fskp3-1.fna&oh=dba1fb70e4827ea764d38d919d284431&oe=5DBC712D",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62255082_10158140479045348_3927652673414758400_n.jpg?_nc_cat=110&_nc_oc=AQkeXf_3Tw6IjMySA0RPEnkHmukfqHPTOnkOp4LF8ESpe_QXcpRfj4ClIpb3L5-kkvw&_nc_ht=scontent.fskp3-1.fna&oh=327fdaf37bef27cafd1290659f2a4b50&oe=5DC505F2",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61891688_10158140479520348_2091146549093466112_n.jpg?_nc_cat=109&_nc_oc=AQmMbQTirtDtQdl0LRCx6oBflBdTDm8pJBhOO4WBZpBX6HXJUh8gZBNPJyzdpz5UY8I&_nc_ht=scontent.fskp3-1.fna&oh=00d4d0b5a7b8d32af7ef69220677856b&oe=5DAD04E8",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61802393_10158140479835348_1003219002165559296_n.jpg?_nc_cat=110&_nc_oc=AQmS41fCIAFS-WqlzgClerSGcPHG_2zzqQbzfpyExrzxWpbmgdpCJyNcESP6wvjBNyQ&_nc_ht=scontent.fskp3-1.fna&oh=1140ec050b8193295d8abf0f9edc5c8b&oe=5DC72778",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62007818_10158140479995348_2027422849467154432_n.jpg?_nc_cat=111&_nc_oc=AQl_baYpwhViikX95I5D8LdbhyoeLVvXdLI4Rzf0LvlSALTzmtSYJsEeaXjRRnGCV8k&_nc_ht=scontent.fskp3-1.fna&oh=f60861fca36f46dbd4890f8b3300a281&oe=5DAE8E39",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61734972_10158140480270348_1341467008373358592_n.jpg?_nc_cat=102&_nc_oc=AQkncLSsPQetItVlzL57magqjAeTybiMFkXg0Ncm1PBj9cyloDP86pINxqK1Bg4URuw&_nc_ht=scontent.fskp3-1.fna&oh=eead2aa19b42431aff195bd4a43ba894&oe=5DBB5B1C",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61992380_10158140480740348_1759041050493583360_n.jpg?_nc_cat=100&_nc_oc=AQlhNomCWB1ALT7nN0lUB6YgPaFylguGmBSQyhFgnapq7vtCMoOD7VPRZ475WhpE5tU&_nc_ht=scontent.fskp3-1.fna&oh=03bf15c61a4046286bd60b1a7d99d7fe&oe=5D792906",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61866319_10158140480935348_2518613301055717376_n.jpg?_nc_cat=106&_nc_oc=AQlvGLJF-5S-YY67RYoLdG-hdv7BwAQm1UeCEIqdOfoHUsRuxD2bCaLdFqtFce8MZLg&_nc_ht=scontent.fskp3-1.fna&oh=9d3ed6866ddb2e3b4dc48204eeabb158&oe=5DB6C87B",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62104657_10158140480635348_622557369276039168_n.jpg?_nc_cat=101&_nc_oc=AQlHwjqzhnQDy3MoqZCPZczFtTL8QG1NGcYjvrggMfA3jE5Fsh3VLC56T4t4wFWUO9A&_nc_ht=scontent.fskp3-1.fna&oh=ed4fc459c6d2c31f94e00cc1f2eb5d02&oe=5D7F8553"
    };

    public String IMGS2 [] = {
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62059257_10158135647155348_4930204594144804864_n.jpg?_nc_cat=104&_nc_oc=AQkpHq9maIVaHTZhwTsOQlnfj1-spcpJ05idZ9BTZJujxiqi1fnY9hJ-JStyeyaXE1A&_nc_ht=scontent.fskp3-1.fna&oh=21a828f7a4eb2484073ec00582a5b037&oe=5DB2027E",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62035341_10158135647140348_8789367339645665280_n.jpg?_nc_cat=102&_nc_oc=AQn8hkd4jHL94YLjaW5y-J_iPD3pKwjmYVk_wyILpmTCrCXVRePpRTxMa1DDldrPRSE&_nc_ht=scontent.fskp3-1.fna&oh=053c9cfdbc8b8e328bde050d9a0357d1&oe=5D797B3F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62141159_10158135647735348_1075037289215688704_n.jpg?_nc_cat=102&_nc_oc=AQnVW8qVeJBzKhhe3vzuYNsO-bZ9OhqGu3g2T6k5HEudxIH-ZoJmdGwWoE438_nFhPw&_nc_ht=scontent.fskp3-1.fna&oh=6f444d82de2b683e51732055aac08f3b&oe=5D78FD8B",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61846509_10158135647910348_8468121889192017920_n.jpg?_nc_cat=109&_nc_oc=AQmq2-ibM5AuZglgSgrUVh3LBSEQjiEoatvlc0JKa0ERVvJXW2-Q_TVs7FUY1hjX0wE&_nc_ht=scontent.fskp3-1.fna&oh=a203a1fb40be35e95c8f6583cc7b4a90&oe=5DAF9E8B",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61691994_10158135648575348_4334486814803886080_n.jpg?_nc_cat=102&_nc_oc=AQmFiVBe2NMh4YhjcgOhbzT-jTaVMqiownVoGgkgIfvtZaIjSMxSiHAXm010n75SUpg&_nc_ht=scontent.fskp3-1.fna&oh=90a136f39ea92033947828b498513694&oe=5DBB933D",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61822445_10158135649080348_6287451814874841088_n.jpg?_nc_cat=100&_nc_oc=AQnQWOUzNnDpZH_z1MDw8R_8R7TyM-n3dXA1aw4teE6TDDPCM0pHIiZcR85L1IVxryA&_nc_ht=scontent.fskp3-1.fna&oh=ef7e02d226ce185c97346fd38cefbf98&oe=5DA88B29",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61657415_10158135649380348_4713035748985536512_n.jpg?_nc_cat=101&_nc_oc=AQm47ZxxhrjSjvL_1m24A6FiRnV7Ic2a4QgEdyLcNbdVM7gkZcJrLEFhe8cwu34yDQk&_nc_ht=scontent.fskp3-1.fna&oh=3f6ead9cc3e20c175eff434cecef5659&oe=5DC71727",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61722546_10158135649605348_4980031901315104768_n.jpg?_nc_cat=107&_nc_oc=AQnXfhzcXegkbYjF3hed27ufruo4PH5reQTWxYILRsUWgujjRBpqhAx8mk-lx0bN3tM&_nc_ht=scontent.fskp3-1.fna&oh=00dc91a16f18b9bf86f83b0872f24de3&oe=5D7CA42D",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61708668_10158135650120348_7776272566989094912_n.jpg?_nc_cat=100&_nc_oc=AQmf8Gw_lPQnbS8Diuhndtf1gL8S5gm9SjeyIrSG2iTI61pmhx7S68Xlb8ZtJi7ksbw&_nc_ht=scontent.fskp3-1.fna&oh=1e333112b2f68037861f64f62c52fd0b&oe=5DAC4B99",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61730541_10158135650395348_2223834392562761728_n.jpg?_nc_cat=105&_nc_oc=AQmzhl6JRIoDEuypPD-KQFPr5e58TeDt2MWpwC2rYjKQRD_h1nkdWnJ2Pl5NiAR0OBY&_nc_ht=scontent.fskp3-1.fna&oh=1ea74d4fe37497b2642a36e32c464ec8&oe=5DB4B481",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62239276_10158135650580348_6021838706439094272_n.jpg?_nc_cat=106&_nc_oc=AQl0vdzlyiUD7pTzRWdtYnKkaNfARoQJBBTiUeI_TyhQvSeFbK_33pqTxPuhjmnfhSw&_nc_ht=scontent.fskp3-1.fna&oh=ff200375215adc6abc2dfd2f8d0b9714&oe=5DAD0090",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61763822_10158135650765348_1903403813369282560_n.jpg?_nc_cat=105&_nc_oc=AQnUMrid7q2DyEQFryfTIYKqhQ8vBEaZ2METYuwrKemFFJPBD_6mYj_-1QB-qRgoDz4&_nc_ht=scontent.fskp3-1.fna&oh=abb438cfc0ddbab3a3634040f4c99217&oe=5DB72016",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61584258_10158135650815348_118842281951232000_n.jpg?_nc_cat=103&_nc_oc=AQlpJK6Qnb9CfZ2027PT-V6JAA3c2H3AW3s_8hzkVyiKO4wPd6kDMxaXSw7u4ZCusBo&_nc_ht=scontent.fskp3-1.fna&oh=822ec10ef1b3e52e9b1b2c612ae91a7b&oe=5DB89A37",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61542851_10158135651555348_8871875216179986432_n.jpg?_nc_cat=108&_nc_oc=AQmhh44tvQoDNWVBh_AOxECP0KMOb7AYH1ZBugEKqW0-Nl6fxqX-n5k9mpfbs-bKusk&_nc_ht=scontent.fskp3-1.fna&oh=c8e31da4b4d13fbe3e1f22fbe04a176c&oe=5D7BA24F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61617742_10158135651625348_2187242177438941184_n.jpg?_nc_cat=106&_nc_oc=AQnjmbd5df_uaawc6ulJboaw8eB2Q28iv-gux68qnswqRUMrAiWbxt8cxpA_-Kgd5v4&_nc_ht=scontent.fskp3-1.fna&oh=45a14fc39662cf0e60244b1b5f191e40&oe=5DA913F1",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62345649_10158135651780348_1645084461345275904_n.jpg?_nc_cat=107&_nc_oc=AQnVuAy-t3QwovvFbX5eC665bu-SUtbzcWCp4Aa0DeAyCWWsCJ9aeaeVfTk92JpYOiE&_nc_ht=scontent.fskp3-1.fna&oh=4596d59c91aff0c9094fb97554f68483&oe=5DAD0F80",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62139311_10158135652015348_1584036410380255232_n.jpg?_nc_cat=108&_nc_oc=AQl0fRknTZBE6V5WVYZa2tsq1Ui7gfGD4e9TOWpM-q0YTmsZUCv62D6HgUDaaq-DhgU&_nc_ht=scontent.fskp3-1.fna&oh=674f56cc56578a2b70da8c16ba609d24&oe=5D7ED984",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61840541_10158135652250348_8829454481327390720_n.jpg?_nc_cat=111&_nc_oc=AQlm0BibJI0L-PG2ySLQhrnC8-nMnyRfDpRBk4fFNt8Yh6fuTqsf65Nd531BQSir_K0&_nc_ht=scontent.fskp3-1.fna&oh=a828576b200cf81fde6bc269dd620e3f&oe=5DA99C85",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61772211_10158135653800348_2106935467348852736_n.jpg?_nc_cat=106&_nc_oc=AQknsulh2XtD6jkcGRptqiLRtXyLM1qNpjCvOj8WRzRtauGJcovxmRt0c4b0URXsZwM&_nc_ht=scontent.fskp3-1.fna&oh=f50c07a6f516cf85062e299fbc666b1f&oe=5D7B6374",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61957920_10158135652765348_7617656744688222208_n.jpg?_nc_cat=109&_nc_oc=AQkjvXL-WYOZ60ZEI3TC_0uGb6Mo9zstXPGLqBSWHhdZ7Ic0QvF0TXHlbzdUzLsfCz4&_nc_ht=scontent.fskp3-1.fna&oh=e2d494c519435210f03703a6f26a9334&oe=5DA81533",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61552830_10158135653590348_6685966475762597888_n.jpg?_nc_cat=108&_nc_oc=AQkiogWYBTJj8q5mfxJIPb7k--DQvK2PwfQYwo9pLrvR03h1sUBAYg7AICERKX_FFak&_nc_ht=scontent.fskp3-1.fna&oh=a47239539bf5f7441511719c61f07d1c&oe=5DAF2E14",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61834520_10158135653690348_3415356129763393536_n.jpg?_nc_cat=104&_nc_oc=AQlmPvtK1TgAIunMr0xINz61Z9CEQUxW5Hn9c0yh_aUv2B2Z0fZFTq6eVqOKseRHl8k&_nc_ht=scontent.fskp3-1.fna&oh=5a9015dabdbd587e50d200378132c68b&oe=5D7FBBD3",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62059519_10158135654955348_4146328472274337792_n.jpg?_nc_cat=103&_nc_oc=AQnS8Odg-p-_ekXwp5BgnDxz84CW-5B83YVJWjgO3X8HfQSsgN28ob5GqvmDYo9YdA8&_nc_ht=scontent.fskp3-1.fna&oh=f87423180bf59cb116810b944c2e5b51&oe=5DBF996C",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61705648_10158135654885348_6670618925526417408_n.jpg?_nc_cat=102&_nc_oc=AQnAz1w_IRYQrGCPlVEt3FF89mz6t1v_lumd0WeKpNjv8oJz0e9sEaV9ejsYL1KAPPA&_nc_ht=scontent.fskp3-1.fna&oh=471e965e491c28f1bda3dda04ddcd88e&oe=5DC105F2",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61661942_10158135655725348_7245439790596751360_n.jpg?_nc_cat=104&_nc_oc=AQmo7qP0q1-gAiYlAIFq6DqW3O_ebdeGie4LWzBPYm7tnW4jRUb8PASiKYz89n17Qsc&_nc_ht=scontent.fskp3-1.fna&oh=6b97b18e8543cf634e6ce3d39b3c7c15&oe=5D7B515C",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61613969_10158135655955348_8102959878445727744_n.jpg?_nc_cat=106&_nc_oc=AQmccF-SgB0j92PbpBj87S15XsyBfbCwARI3Zs6iRPhqQBUo4sVz4kBSwH_P9btx5Sg&_nc_ht=scontent.fskp3-1.fna&oh=1e3dabda60a39ddc154f0951f2384736&oe=5DBDD15F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61988873_10158135651885348_4730899802164822016_n.jpg?_nc_cat=106&_nc_oc=AQkQHHlyueDtaeZG1SjdCwypYA7cjgZ2LP6yyAylvGfrjpAAatYbfbDBvSc9rDR3iE8&_nc_ht=scontent.fskp3-1.fna&oh=1cc4549a5cf4f2a7ce8d3372da4299f4&oe=5DAC419E"
    };

    public String IMGS3 [] = {
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61469967_10158131920565348_3431813881800949760_n.jpg?_nc_cat=109&_nc_oc=AQk0i1rL8vaBC85p8XmtlCqiowWnvhrNtN6TTO24SvZcy2ND4CMJNqzB8Vcsr0hb07c&_nc_ht=scontent.fskp3-1.fna&oh=0041506ddf35ff67dd1f07117cb0d5aa&oe=5DBC743F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61981184_10158131920585348_3929050234298040320_n.jpg?_nc_cat=108&_nc_oc=AQnfRA9VZElAl6dyTeg_EOZVwykWARrATOhQX46KcXO6TeR0DxhJWtdxKtwYRNcehGc&_nc_ht=scontent.fskp3-1.fna&oh=07df30ac46fae5a1e06a5d38ed989c3b&oe=5DB76771",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62081516_10158131920900348_2028758936483528704_n.jpg?_nc_cat=100&_nc_oc=AQmtMIWpWESdMuQps5yuNDMBR7ipC_P0BwcVdUE8U3rak5ev4VXWw6hahXXviDsIn8Y&_nc_ht=scontent.fskp3-1.fna&oh=203f698f7f423d26cbc2953846adf6a0&oe=5DB4AF44",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61688784_10158131920930348_1340853321971269632_n.jpg?_nc_cat=100&_nc_oc=AQmbCcHGpi1eD-CMcpNnvhnQ10ns6N5ARAqHe6o7Q6z1YI1ohU7XV2UBBY1JKnJTht0&_nc_ht=scontent.fskp3-1.fna&oh=34adf18da943c0704af7a3c63714b6db&oe=5DBFCC22",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61492708_10158131921180348_1693110343267516416_n.jpg?_nc_cat=100&_nc_oc=AQncji7KhVjNrdJRtklEzzWPPiPdBsH01hPd2a_cso6bIdGO1ZZfeHe_HEkySHP7T1A&_nc_ht=scontent.fskp3-1.fna&oh=6d7aaeb65285fe3c5e2490adf457923d&oe=5DB81F8F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61735635_10158131921190348_2780161562248216576_n.jpg?_nc_cat=107&_nc_oc=AQmcnhRSXn-jVMLB0y60M0ypUQC0uBfmsV69dJK7CPHtPh9toyR0MptBnNikEDEvAQI&_nc_ht=scontent.fskp3-1.fna&oh=220bc9b6fb97c317110d498236cc7f2f&oe=5DC10582",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61724688_10158131921590348_851550169206882304_n.jpg?_nc_cat=108&_nc_oc=AQnR6iWpugC9TDBj_XvHPyAqaPQNsE7lNlwMUII4oQ29mS_SVH1E7LOpx8XdVBbC51Q&_nc_ht=scontent.fskp3-1.fna&oh=016d8c7662f9a6d78d71af589c0bda22&oe=5DB9EDBA",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61646861_10158131921775348_5250836611599433728_n.jpg?_nc_cat=110&_nc_oc=AQlLzrbdvtPBmRq_864wZxM8R1ii7IIQY1dfMT7WUkuXc4VdxGDojkdMY7uiLD9b4K0&_nc_ht=scontent.fskp3-1.fna&oh=2f9a5ec1ef4cff7647f2cdc277cb71d2&oe=5DB40A85",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61866584_10158131921935348_2368144666643136512_n.jpg?_nc_cat=109&_nc_oc=AQk7KmiZKAIxdMAUnOpNTbSxrf4RHaWI_Rtt4kTJsxdm2WO-YEQLjVLEmn4_F5vxC5Q&_nc_ht=scontent.fskp3-1.fna&oh=66b92c0dfc4cacff40d110e4cd3ec055&oe=5DBFA48E",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61910220_10158131922145348_258625986919137280_n.jpg?_nc_cat=111&_nc_oc=AQluByGqejN1NPPCZ0lp1dEiiMys--Swu1OuD4RkYANogxGp3la6__F4QcvpjRE2IAg&_nc_ht=scontent.fskp3-1.fna&oh=f8019e5fa103217f8f0b2cf9a995e828&oe=5DC7252A",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61523813_10158131922505348_1940107298210840576_n.jpg?_nc_cat=105&_nc_oc=AQnFs1ZDYzq1VEhGqI7KTukR3B_PMK99314KRNPiETwafuo4dGVLskFIDDBdRmm-KSY&_nc_ht=scontent.fskp3-1.fna&oh=3eeb1b65ab1cb33918ee664edf53125b&oe=5DC66F3A",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61648933_10158131922710348_4670103693981384704_n.jpg?_nc_cat=110&_nc_oc=AQl0sDQbpwCs4sCL9282YMJXdlbk8RUv1p1jXMUpVve1wMq5TANuxoEv9eVNTsZjHhM&_nc_ht=scontent.fskp3-1.fna&oh=ba0130ab24c8902f2644b0e3ee708320&oe=5DB5008C"
    };

    public  String IMGS4 [] = {
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62147781_10158141187305348_6420582138759872512_n.jpg?_nc_cat=100&_nc_oc=AQnHxLdXok3_XPZrAiIqU4wQRc960B60eiqhf40FR4Lc_PDPZfF2kSbXVnFpZR32q4Q&_nc_ht=scontent.fskp3-1.fna&oh=d98247f8319572731e0aebbd35270a53&oe=5DA79DDA",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61769003_10158141188955348_1153258096898867200_n.jpg?_nc_cat=102&_nc_oc=AQn0pigs2tNvi9_35tr_sm0FLSvaWB3cFL4-Gi9HjL0-K1y78igEUMu-mHcsjwqzzVk&_nc_ht=scontent.fskp3-1.fna&oh=bed2177347b0eb7bba037675b3d7d4d8&oe=5DAE638A",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61937470_10158141188435348_56703807509233664_n.jpg?_nc_cat=108&_nc_oc=AQlPZB5NpY26n4kXeG9ARpQTFPxlmlnwI1UJPZ9ZQ5ZeVbUhTG5IDT4_Rh3BtrWx54U&_nc_ht=scontent.fskp3-1.fna&oh=6e8198d7a0147df329e6e1b6b169d3ad&oe=5DBE1494",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61785668_10158141188085348_4082946506015899648_n.jpg?_nc_cat=101&_nc_oc=AQkWpHBDbZzj-KhcJliN-PA5Bko3DRzXnsZW9XSGEJJp8hNHcUUmBOFqsGdcr5QTYio&_nc_ht=scontent.fskp3-1.fna&oh=177bc23adaed45f82a51f9542390e573&oe=5DB1016F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61759437_10158141188210348_1110168094472404992_n.jpg?_nc_cat=105&_nc_oc=AQlZwwU4qRn7HfQzGX097FH4PMQq4ULtTQBUbb_ymMy99EjutA3u4dVNv0ZWwtVNXvQ&_nc_ht=scontent.fskp3-1.fna&oh=839905e1fd4d2bb16ec9169e37f5bb42&oe=5DB1CB2F",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61981185_10158141187705348_3049026145610629120_n.jpg?_nc_cat=106&_nc_oc=AQmlI_ETkKPbZBgSKC0cXbqhohW7XlQNtRET-C2fgGxt8x9CdtNs4YIlWLjYjno4fY4&_nc_ht=scontent.fskp3-1.fna&oh=790d0714ac2347e4f3e78b3e3deb6a44&oe=5DB13032",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62174836_10158141189765348_9092831505234788352_n.jpg?_nc_cat=106&_nc_oc=AQmV8I-o9vENV9eTkZTryJofQpZBrhJkWOlsatmMtFqEcroCcFcjw_B_4LsMRhWFL-4&_nc_ht=scontent.fskp3-1.fna&oh=f1265b3ad644998ea7218ef9443fe348&oe=5DBA5923",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61992086_10158141189630348_4084177645506396160_n.jpg?_nc_cat=105&_nc_oc=AQmj0Omv1rRWpFG8a6U-xRXfagG2bgdM9IVkw5r7fnC4GSK6uzVUENHqQkV5p3yslFA&_nc_ht=scontent.fskp3-1.fna&oh=429bc756bdf426815cee38bd87a5cd41&oe=5DC42526",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61834200_10158141189305348_4881304286945869824_n.jpg?_nc_cat=107&_nc_oc=AQkSvhbE6on4WysD6PNKsSVKam1PQx90hdeESuc98sySh1avxt4x2AsVNWVn4Bur_EA&_nc_ht=scontent.fskp3-1.fna&oh=0948e44e81a98f640ad31004e5e58ee6&oe=5DBB821D",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61975977_10158141191435348_775019164866707456_n.jpg?_nc_cat=104&_nc_oc=AQmX5YquHJ1AgxbfETAFfrFDvSaq3p9AQOxp5_58SFmPEHRYo9C5dJqOxv0G2efZTIw&_nc_ht=scontent.fskp3-1.fna&oh=05cdba47595f3623e17ffd94f658ecfc&oe=5DAF2C74",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62004660_10158141191795348_4592560125331374080_n.jpg?_nc_cat=103&_nc_oc=AQlaKvE6Lpmd6j4UIYmCyj4IRDy_9OY9ATs7Aq8MrCov14ZNAYL5bKjyISuuEjtkYh8&_nc_ht=scontent.fskp3-1.fna&oh=5e4ec25e267972f231a70768708415cd&oe=5DB41266",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61948801_10158141191635348_7843598923837997056_n.jpg?_nc_cat=104&_nc_oc=AQlvxUUh8McAmdrw1Y9GDj5AWDZwLmY3smtZR8BHJDB1ZWM_5gsdHWStYa0O1Wcn4pE&_nc_ht=scontent.fskp3-1.fna&oh=724c843737546b1752887879e8a4faf4&oe=5DBD34B5",
            "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61767643_10158141191990348_8486032821939339264_n.jpg?_nc_cat=102&_nc_oc=AQmUwhdqv3WC1bfFgIbrR82IXOn8PxhujKMHtOZrRdCxdLrEviRzeMhjgQq60N0eEsU&_nc_ht=scontent.fskp3-1.fna&oh=136ad04ebdf49ece2cd4727b3945eb7f&oe=5DAB014B"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery);
        Intent intent = getIntent();
        int pos=0;
        if(intent.hasExtra("extra_gallery")) {
            pos=intent.getIntExtra("pos_gallery", 0);
            if(pos==0) {
                for (int i = 1; i <= IMGS.length; i++) {
                    ImageModel imageModel = new ImageModel();
                    imageModel.setName("Слика " + i + " / " + IMGS.length);
                    imageModel.setUrl(IMGS[i - 1]);
                    data.add(imageModel);

                }
            }

            if(pos==1){
                for (int i = 1; i <= IMGS4.length; i++) {
                    ImageModel imageModel = new ImageModel();
                    imageModel.setName("Слика " + i + " / " + IMGS4.length);
                    imageModel.setUrl(IMGS4[i - 1]);
                    data.add(imageModel);

                }
            }

            if(pos==2){
                for (int i = 1; i <= IMGS2.length; i++) {
                    ImageModel imageModel = new ImageModel();
                    imageModel.setName("Слика " + i + " / " + IMGS2.length);
                    imageModel.setUrl(IMGS2[i - 1]);
                    data.add(imageModel);

                }
            }

            if(pos==3){
                for (int i = 1; i <= IMGS3.length; i++) {
                    ImageModel imageModel = new ImageModel();
                    imageModel.setName("Слика " + i + " / " + IMGS3.length);
                    imageModel.setUrl(IMGS3[i - 1]);
                    data.add(imageModel);

                }
            }
        }



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new GalleryAdapter(GalleryActivity.this, data);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(GalleryActivity.this, DetailsActivity.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));

    }
}
