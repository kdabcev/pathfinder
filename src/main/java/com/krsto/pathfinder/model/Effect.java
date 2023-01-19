package com.krsto.pathfinder.model;

import java.util.List;
import java.util.Objects;


import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;
import com.krsto.pathfinder.model.EffectFactory.EffectEnum;

public abstract class Effect {

		private EffectEnum effectEnum;
			
		protected boolean isActive;
		
		public abstract void activate(CharacterAttributes attributes);

		public Effect(EffectEnum effectEnum) {
			this.effectEnum = effectEnum;
		}

		@Override
		public int hashCode() {
			return Objects.hash(effectEnum);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Effect other = (Effect) obj;
			return Objects.equals(effectEnum, other.effectEnum);
		}

		public EffectEnum getEffectEnum() {
			return effectEnum;
		}
}

