import Vue from 'vue';
import Router from 'vue-router';
import HelloWorld from '@/components/HelloWorld';
import Produtos from '@/components/Produtos';
import Produto from '@/components/Produto';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
    },
    {
      path: '/produtos',
      name: 'Produtos',
      component: Produtos,
    },
    {
      path: '/produtos/:id',
      name: 'Produto',
      component: Produto,
    },
  ],
});
