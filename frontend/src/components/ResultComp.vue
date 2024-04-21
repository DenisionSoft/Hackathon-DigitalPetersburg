<template>
    <div id="field">
        <div id="heading">
            <div id="logo">
                <img id="logo_img" src="@/assets/bar_black.png">
                <div id="logo_text">Хочу здесь жить</div>
            </div>
            <div id="result_field">
                <div id="result_text">Оценка района для дома</div> 
                <div id="address">по адресу {{adress}}</div> 
                <div id="index" :style="{color: color}">{{index}}</div>
            </div>
            <div id="parameters">
                <div v-for="(parameter, key) in parameters" :key="key">
                    <div  id="parameter" v-if="parameter">{{setParams(key)}}</div>
                </div>
            </div>
        </div>
        <img src="@/assets/rezultat.png" alt="">
    </div>
      
</template>

<script>
export default {
    name: 'ResultComp',
    data() {
        return {
            color: this.calcColor(this.index),
            params_names: {
                'metroValue' : 'Метро', 
                'educationValue' : 'Образование', 
                'sportValue' : 'Спортивная доступность', 
                'dosugValue' : 'Досуг', 
                'petsValue' : 'Для питомцев', 
                'kudagoValue' : 'Активности KudaGo'
            },
        }
    },
    props: ['index',
            'adress',
            'parameters'],
    methods: {
        calcColor: function(index) {
            var r, g, b
            var reverse_ind = 100 - index
            var colour_num = ((reverse_ind)*5440000/100)+11110000
            var h = 1 - (colour_num/16777215)
            var i= ~~(h*6)
            var f = h*6-i
            var q = 1 - f
            switch(i%6){
                case 0: r = 1; g = f; b = 0; break;
                case 1: r = q; g = 1; b = 0; break;
                case 2: r = 0; g = 1; b = f; break;
                case 3: r = 0; g = q; b = 1; break;
                case 4: r = f; g = 0; b = 1; break;
                case 5: r = 1; g = 0; b = q; break;
            }
            return "#" + ("00"+(~~(r*255)).toString(16)).slice(-2) + ("00"+(~~(g*255)).toString(16)).slice(-2) + ("00"+(~~(b*255)).toString(16)).slice(-2)
        },
        setParams(index){
            return this.params_names[index]
        }
    },

}
</script>

<style scoped>
#field{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    height: 790px;
    background-color: #e8edf3;
    border-radius: 32px;
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
#result_field{
    margin-top: 81px;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-inline: 200px;
}
#result_text{
    font-size: 40px;
    font-weight: bold;
}
#address{
    font-size: 26px;
    margin-top: 20px;
}
#index{
    font-size: 200px;
    margin-top: 20px;
}
#pic{
    min-width: 495px;
}
#parameters{
    margin-left: 116px;
    margin-top: 64px;
    height:max-content;
    display: flex;
}
#parameter{
    flex: 1;
    margin-inline: 65px;
    font-size: 26px;
}
</style>