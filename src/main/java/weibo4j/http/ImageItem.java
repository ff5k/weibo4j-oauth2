package weibo4j.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;

import weibo4j.model.Constants;
import weibo4j.model.WeiboException;

import com.sun.imageio.plugins.bmp.BMPImageReader;
import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.jpeg.JPEGImageReader;
import com.sun.imageio.plugins.png.PNGImageReader;

/**
 * 临时存储上传图片的内容，格式，文件信息等
 *
 * @author user1
 * @version $Id: $Id
 */
public class ImageItem {
	private byte[] content;
	private String name;
	private String contentType;

	/**
	 * <p>Constructor for ImageItem.</p>
	 *
	 * @param content an array of {@link byte} objects.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public ImageItem(byte[] content) throws WeiboException {
		this(Constants.UPLOAD_MODE, content);
	}

	/**
	 * <p>Constructor for ImageItem.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param content an array of {@link byte} objects.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public ImageItem(String name, byte[] content) throws WeiboException {
		String imgtype = null;
		try {
			imgtype = getContentType(content);
		} catch (IOException e) {
			throw new WeiboException(e);
		}

		if (imgtype != null
				&& (imgtype.equalsIgnoreCase("image/gif")
						|| imgtype.equalsIgnoreCase("image/png") || imgtype
							.equalsIgnoreCase("image/jpeg"))) {
			this.content = content;
			this.name = name;
			this.contentType = imgtype;
		} else {
			throw new WeiboException(
					"Unsupported image type, Only Suport JPG ,GIF,PNG!");
		}
	}

	/**
	 * <p>Getter for the field <code>content</code>.</p>
	 *
	 * @return an array of {@link byte} objects.
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * <p>Getter for the field <code>name</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>Getter for the field <code>contentType</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * <p>Getter for the field <code>contentType</code>.</p>
	 *
	 * @param mapObj an array of {@link byte} objects.
	 * @return a {@link java.lang.String} object.
	 * @throws java.io.IOException if any.
	 */
	public static String getContentType(byte[] mapObj) throws IOException {

		String type = "";
		ByteArrayInputStream bais = null;
		MemoryCacheImageInputStream mcis = null;
		try {
			bais = new ByteArrayInputStream(mapObj);
			mcis = new MemoryCacheImageInputStream(bais);
			Iterator itr = ImageIO.getImageReaders(mcis);
			while (itr.hasNext()) {
				ImageReader reader = (ImageReader) itr.next();
				if (reader instanceof GIFImageReader) {
					type = "image/gif";
				} else if (reader instanceof JPEGImageReader) {
					type = "image/jpeg";
				} else if (reader instanceof PNGImageReader) {
					type = "image/png";
				} else if (reader instanceof BMPImageReader) {
					type = "application/x-bmp";
				}
			}
		} finally {
			if (bais != null) {
				try {
					bais.close();
				} catch (IOException ioe) {

				}
			}
			if (mcis != null) {
				try {
					mcis.close();
				} catch (IOException ioe) {

				}
			}
		}
		return type;
	}
}
