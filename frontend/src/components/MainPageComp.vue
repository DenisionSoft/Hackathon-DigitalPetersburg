<template>
    <div id="heading">
        <div id="left_block">
            <div id="logo">
                <img id="logo_img" src="@/assets/bar_black.png">
                <div id="logo_text">Хочу здесь жить</div>
            </div>
            <div id="heading_text">Найти лучший дом для жизни в Санкт-Петербурге</div>
            <div id="subheading_text">Наш сервис оценивает качество района и жилого дома для полной и счастливой жизни</div>
            <div id="btns">
                <button id="adress_btn_left" @click="$emit('page', 1)">Оценить</button>
                <button id="try_btn" @click="scrollToExample">Примеры</button>
            </div>
        </div>
        <div id="right_block">
            <div id="menu">
                <div ><a id="about" href="#aboutField">О нас</a></div>
                <div id="support">Поддержка</div>
                <div id="contacts">Контакты</div>
                <button id="adress_btn_right" @click="$emit('page', 1)">Оценить</button>
            </div>
        </div>
    </div>
    <div id="aboutField">
        <a name="aboutField"></a>
        <div id="about_label">О нас</div>
        <hr id = "line">
        <div id="about_text">Наша команда создала сервис для жителей <mark class="blue">Санкт-Петербурга</mark>, 
        которые выбирают себе новое место для жизни. Мы поможем сравнить районы по важным для вас <mark class="blue">критериям</mark>, 
        оценим количество важных <mark class="blue">социальных объектов</mark> в выбранном радиусе доступности, 
        а также отметим <mark class="blue">серьезные проблемы</mark>, которые указали жители дома.</div>
        <hr id = "line">
        <div id="how_to_use_label">Как пользоваться сервисом</div>
        <div id="how_to_use">
            <div id="search">
                <img id="search_img" src="@/assets/search.png" alt="">
                <div id="search_text">Найди интересующий дом по адресу или на карте</div>
            </div>
            <div id="choose">
                <img id="choose_img" src="@/assets/histogram.png" alt="">
                <div id="choose_text">Выбери параметры для оценки - радиус района, важные социальные инфраструктуры и т. д.</div>
            </div>
            <div id="find">
                <img id="find_img" src="@/assets/like.png" alt="">
                <div id="find_text">Найди район для проживания на основе оценок</div>
            </div>
        </div>
    </div>
    <div id="exampleField">
        <a name="exampleField"></a>
        <div id="example_label">Попробуйте примеры</div>
        <div id="example_columns">
            <div id="example_metro">
                <div id="example_heading">Метро</div>
                <div id="metro_btns">
                    <div id="metro_petr">
                        <img id="metro_blue" src="@/assets/metro_blue.png" alt="">
                        <div id="blue_text">Петроградская</div>
                    </div>
                    <div id="metro_kanal">
                        <img id="metro_purple" src="@/assets/metro_purple.png" alt="">
                        <div id="purple_text">Обводный канал</div>
                    </div>
                    <div id="metro_politekh">
                        <img id="metro_red" src="@/assets/metro_red.png" alt="">
                        <div id="red_text">Политехническая</div>
                    </div>
                </div>
            </div>
            <div id="example_buildings">
                <div id="example_heading">От застройщика</div>
                <div id="buildings_btns">
                    <div id="buildings_volt">
                        <img id="buildings_pik" src="@/assets/pik.png" alt="">
                        <div id="volt_text">ЖК "Вольта"</div>
                    </div>
                    <div id="buildings_air">
                        <img id="buildings_pik" src="@/assets/pik.png" alt="">
                        <div id="air_text">ЖК "Аэронавт"</div>
                    </div>
                    <div id="buildings_toriki">
                        <img id="buildings_plain" src="@/assets/plain.png" alt="">
                        <div id="toriki_text">Квартал Торики</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'MainPageComp',
  emits: ['page'],
  methods: {
    scrollToExample() {
      const exampleField = document.getElementById('exampleField');
      if (exampleField) {
        exampleField.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    }
  }
}
</script>

<style scoped>
#heading{
    height: 657px;
    background-color: white;
    border-radius: 32px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
#logo{
  display: flex;
  justify-content: left;
}
#logo_img{
  width: 27px;
  height: 36px;
  margin-left: 35px;
  margin-top: 17px;
}
#logo_text{
  font-size: 24px;
  margin-left: 11px;
  margin-top: 29px;
  font-weight: bold;
}
#left_block{
    width: 50%;
}
#right_block{
    border-top-right-radius: 32px;
    border-bottom-right-radius: 32px;
    min-width: 814px;
    background-image: url("@/assets/background_1.png");
}
#heading_text{
    font-size: 40px;
    margin-top: 96px;
    font-weight: bold;
    margin-inline: 35px;
}
#subheading_text{
    margin-inline: 35px;
    font-size: 20px;
    margin-top: 18px;
}
#btns{
    margin-left: 35px;
    display: flex;
    flex-direction: row;
    justify-content: left;
    margin-top: 41px;
}
#adress_btn_left, #try_btn{
    border-radius: 83px;
    width: 200px;
    font-size: 26px;
    padding: 0;
}
#adress_btn_left:hover, #try_btn:hover, #adress_btn_right:hover, #about:hover{
    cursor: pointer;
}
#adress_btn_left{
    background-color: #4E7BB4;
    border: none;
    color: white;
    height: 51px;
}
#try_btn{
    background-color: white;
    border-style: solid;
    color: #4E7BB4;
    border-color: #4E7BB4;
    height: 51px;
    margin-left: 24px;
}
#menu{
    display: flex;
    flex-direction: row;
    justify-content: right;
    margin-top: 32px;
    margin-right: 52px;
}
#about, #support, #contacts{
    font-size: 24px;
    color: white;
    font-weight: bold;
    margin-right: 40px;
    text-decoration: none;
}
#adress_btn_right{
    border-radius: 83px;
    width: 147px;
    font-size: 24px;
    padding: 0;
    background-color: white;
    border:none;
    color: #4E7BB4;
    height: 38px;
    font-weight: bold;
}
#aboutField{
    border-radius: 32px;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: white;
    margin-top: 31px;
    height: 690px;
}
#about_label, #example_label{
    font-size: 40px;
    font-weight: bold;
    margin-block: 33px;
}
#how_to_use_label{
    font-size: 40px;
    font-weight: bold;
    margin-block: 42px;
}
#about_text{
    width: 872px;
    text-align: center;
    font-size: 20px;
    margin-block: 32px;
}
mark.blue{
    background: none;
    color: #4E7BB4;
}
#line{
    border-color:#6A97D0;
    border-style: solid;
    color: #6A97D0;
    width: 85%;
    size: 2px;
}
#how_to_use{
    display: flex;
    flex-direction: row;
    align-items: center;
}
#search, #choose, #find{
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    width: 359px;
    height: 180px;
    margin-inline: 20px;
    font-size: 20px;
}
#search_img, #choose_img, #find_img{
    width: 60px;
    height: 60px;
    margin-bottom: 43px;
}

#exampleField{
    border-radius: 32px;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: white;
    margin-top: 31px;
    height: 430px;
}

#metro_blue, #metro_purple, #metro_red{
    width: 50px;
    height: 50px;
    margin-bottom: 27px;
}
#buildings_pik{
    height: 30px;
    margin-bottom: 27px;
}

#buildings_plain{
    weight: 30px;
    height: 46px;
    margin-bottom: 27px;
}

#blue_text, #purple_text, #red_text, #volt_text, #air_text, #toriki_text{
    text-align: center;
    font-size: 26px;
    text-decoration: underline;
    margin-left:20px;
}

#example_heading{
    font-size: 32px;
    font-weight: bold;
    color: #4E7BB4;
    margin-bottom: 10px;
}

#example_columns{
    display: flex;
    flex-direction: row;
    align-items: center;
}

#metro_petr, #metro_kanal, #metro_politekh, #buildings_volt, #buildings_air, #buildings_toriki{
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 70px;
}


#example_metro, #example_buildings{
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-inline: 20px;
    text-align: center;
    margin-inline: 200px;
    weight: 350px;
    height: 300px;
}


</style>