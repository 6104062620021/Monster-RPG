import java.io.IOException;

import org.lwjgl.opengl.GL11;


public class CameraBattle extends Camera {

	Battle objBattle;
	Texture texture = null;
	public CameraBattle(Battle battle) {
		
		objBattle = battle;
	}
	@Override
	public void render() {
	for(int x = 0;x<9;x++)
	{
		for(int y = 0;y<5;y++)
		{
		
			renderHex(objBattle.hextiles[x][y]);
		}
	}
	}
	private void renderHex(HexTile hexTile) {
		try {
			texture = textureLoader.getTexture("sprites/hexagonAlpa32.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GL11.glPushMatrix();
		texture.bind();
		GL11.glColor3f(1,1,1);
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA); 
		GL11.glEnable(GL11.GL_BLEND);  
		GL11.glBegin(GL11.GL_QUADS);
		float y = (float) (hexTile.y + (hexTile.even ? 2:2.5));
		float x = (float) (hexTile.x + ((-1.7*hexTile.x))+8);
		
		
		
		GL11.glTexCoord2f((texture.getWidth()), 0);
		GL11.glVertex2f(x*32  , y*32 );
		GL11.glTexCoord2f((texture.getWidth()), texture.getHeight());
		GL11.glVertex2f(x*32 , y*32 + 32 );
		GL11.glTexCoord2f((texture.getWidth())+texture.getWidth(), texture.getHeight());
		GL11.glVertex2f(x*32 + 32 ,y*32 + 32);
		GL11.glTexCoord2f((texture.getWidth())+texture.getWidth(), 0);
		GL11.glVertex2f(x*32 + 32 ,y*32);
		
		GL11.glEnd();
		GL11.glPopMatrix();
	
	}
	public void renderWild() {
		 int currentWildx = TileLongGrass.currentWild.x;
		 int currentWildy = TileLongGrass.currentWild.y;
		try {
		texture = textureLoader.getTexture("sprites/hexagon16.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GL11.glPushMatrix();
		texture.bind();
		GL11.glColor3f(1,1,1);
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA); 
		GL11.glEnable(GL11.GL_BLEND);  
		GL11.glBegin(GL11.GL_QUADS);
		float y = (float) (currentWildy);
		float x = (float) (currentWildx);
		
		
		
		GL11.glTexCoord2f((texture.getWidth()), 0);
		GL11.glVertex2f(x*16  , y*16 );
		GL11.glTexCoord2f((texture.getWidth()), texture.getHeight());
		GL11.glVertex2f(x*16 , y*16 + 16 );
		GL11.glTexCoord2f((texture.getWidth())+texture.getWidth(), texture.getHeight());
		GL11.glVertex2f(x*16 + 16 ,y*16 + 16);
		GL11.glTexCoord2f((texture.getWidth())+texture.getWidth(), 0);
		GL11.glVertex2f(x*16 + 16 ,y*16);
		
		GL11.glEnd();
		GL11.glPopMatrix();
	
	
}

	

}


