<template>
  <v-layout row wrap>
    <v-flex xs4>
      <v-card>
        <v-card-title primary-title>
          <div>
            <div class="headline">{{ produto.descricao }}</div>
            <span class="grey--text">{{ produto.dataCadastro }}</span>
          </div>
        </v-card-title>
        <v-card-text>
          {{ produto.urlImagem }}
        </v-card-text>
      </v-card>
    </v-flex>
  </v-layout>
</template>
<script>
import axios from 'axios';

export default {
  name: 'Produto',
  data() {
    return {
      produto: [],
    };
  },
  mounted() {
    this.fetchProduto();
  },
  methods: {
    async fetchProduto() {
      return axios({
        method: 'get',
        url: `http://localhost:8085/produtos/${this.$route.params.id}`,
      })
        .then((response) => {
          this.produto = response.data;
        })
        .catch(() => {
        });
    },
  },
};
</script>