<template>
    <div id="loading_field">
        <div id="logo">
            <img id="logo_img" src="@/assets/bar_black.png">
            <div id="logo_text">Хочу здесь жить</div>
        </div>
        <div id="loading">
            <div id="loading_text">Считаем результат...</div>
            <img id="loading_img" src="@/assets/loading.gif" alt="">
        </div>
    </div>
</template>

<script>
export default {
    name: 'LoadingComp'
}
</script>

<style scoped>
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
#loading_field{
    height: 400px;
    background-color: white;
    border-radius: 32px;
}
#loading{
    padding-top: 53px;
    padding-bottom: 126px;
    display: flex;
    flex-direction: column;
    align-items: center;
}
#loading_text{
    font-weight: bold;
    font-size: 40px;
}
#loading_img{
    width: 120px;
    height: 120px;
    margin-top: 40px;
}
</style>