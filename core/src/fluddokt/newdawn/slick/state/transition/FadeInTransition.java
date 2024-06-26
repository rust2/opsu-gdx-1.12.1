/*
 * Copyright (c) 2013, Slick2D
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the Slick2D nor the names of its contributors may be
 *   used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package fluddokt.newdawn.slick.state.transition;
/*
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
*/

import fluddokt.opsu.fake.Color;
import fluddokt.opsu.fake.GameContainer;
import fluddokt.opsu.fake.GameState;
import fluddokt.opsu.fake.Graphics;
import fluddokt.opsu.fake.StateBasedGame;


/**
 * A transition to fade in from a given colour
 *
 * @author kevin
 */
public class FadeInTransition implements Transition {
	/** The color to fade to */
	private Color color;
	/** The time it takes to fade in */
	private int fadeTime = 500;

	/**
	 * Create a new fade in transition
	 */
	public FadeInTransition() {
		this(Color.black, 500);
	}
	
	/**
	 * Create a new fade in transition
	 * 
	 * @param color The color we're going to fade in from
	 */
	public FadeInTransition(Color color) {
		this(color, 500);
	}
	
	/**
	 * Create a new fade in transition
	 * 
	 * @param color The color we're going to fade in from
	 * @param fadeTime The time it takes for the fade to occur
	 */
	public FadeInTransition(Color color, int fadeTime) {
		this.color = new Color(color);
		this.color.a = 1;
		this.fadeTime = fadeTime;
	}
	
	/**
	 * @see org.newdawn.slick.state.transition.Transition#isComplete()
	 */
	@Override
	public boolean isComplete() {
		return (color.a <= 0);
	}

	/**
	 * @see org.newdawn.slick.state.transition.Transition#postRender(org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	@Override
	public void postRender(GameContainer container, Graphics g) {
		Color old = g.getColor();
		g.setColor(color);
		
		g.fillRect(0, 0, container.getWidth()*2, container.getHeight()*2);
		g.setColor(old);
	}
	
	/**
	 * @see org.newdawn.slick.state.transition.Transition#update(org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(GameContainer container, int delta) {
		color.a -= delta * (1.0f / fadeTime);
		if (color.a < 0) {
			color.a = 0;
		}
	}

	/**
	 * @see org.newdawn.slick.state.transition.Transition#preRender(org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	@Override
	public void preRender(GameContainer container, Graphics g) {}

	@Override
	public void init(GameState firstState, GameState secondState) {}
}
