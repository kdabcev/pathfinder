export default {
  
  data() {
    return {
		attributes : ["Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"],
	}
  },
  methods: {
    
  },
  template: `<div v-for="attribute in attributes"> <AttributeComponent v-model:name="attribute" ></AttributeComponent> </div> `
}