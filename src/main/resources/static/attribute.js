export default {
  props: ['name'],
  data() {
    return { 
	  value : 10,
    }

  },
  methods: {
    
  },
  template: `{{ name }} <input type="number" v-model="value">`
}