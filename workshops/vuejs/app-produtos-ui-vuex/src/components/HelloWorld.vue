<template>
  <v-layout row wrap>
    <v-flex xs4 v-for="p in produtos" :key="p.id">
      <v-card>
        <v-card-title primary-title>
          <div>
            <div class="headline">
              <v-btn flat v-bind:to="`/produtos/${p.id}`">
                {{ p.descricao }}
              </v-btn>
            </div>
            <span class="grey--text">{{ p.dataCadastro }}</span>
          </div>
        </v-card-title>
        <v-card-text>
          <v-btn outline color="indigo" v-bind:to="`/produtos/${p.id}`">{{ p.urlImagem }}</v-btn>
        </v-card-text>
      </v-card>
    </v-flex>
  </v-layout>
</template>
<script>
import axios from 'axios';

export default {
  name: 'HelloWorld',
  computed: {
    produtos() {
      return this.$store.getters.fetchProdutos;
    }
  },
  mounted() {
    this.$store.dispatch("fetchProdutos");
  },
  // data() {
  //   return {
  //     produtos: [],
  //   };
  // },
  // mounted() {
  //   this.fetchProdutos();
  // },
  // methods: {
  //   async fetchProdutos() {
  //     return axios({
  //       method: 'get',
  //       url: 'http://localhost:8085/produtos',
  //     })
  //       .then((response) => {
  //         this.produtos = response.data;
  //       })
  //       .catch(() => {
  //       });
  //   },
  // },
};
</script>