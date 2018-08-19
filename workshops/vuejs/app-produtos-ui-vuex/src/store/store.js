import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        produtos: []
    },
    getters: {
        fetchProdutos: state => state.produtos,
    },
    mutations: {
        ADD_PRODUTO: (state, payload) => {
            state.produtos.unshift(payload);
        },
        PRODUTOS: (state, payload) => {
            state.produtos = payload;
        }
    },
    actions: {
        addProduto: (context, payload) => {
            return axios({
                method: 'post',
                data: payload,
                url: '/produtos',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
                .then((response) => {
                    context.commit("ADD_PRODUTO", response.data)
                    this.$swal(
                        'Great!',
                        'Produto adicionado com sucesso.',
                        'success',
                    );
                })
                .catch(() => {
                    this.$swal(
                        'Oh oo!',
                        'O produto não foi adicionado.',
                        'error',
                    );
                });
        },
        fetchProdutos: (context, payload) => {
            axios({
                method: 'get',
                url: 'http://localhost:8085/produtos',
            })
                .then((response) => {
                    context.commit("PRODUTOS", response.data);
                })
                .catch(() => {
                });
        }
    }
})