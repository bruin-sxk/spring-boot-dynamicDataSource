package com.sxk.common.fomat.util;

import com.sxk.common.fomat.pdf.Html2Pdf;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class PdfExportUtil {


	/**
	 * ͨ��HTMLģ������PDF(��֧�ָ߼�CSS��ʽ)
	 * <p>
	 * htmlģ��ע�����
	 * <p>
	 * 1.charset�������ã�windows��ʹ��GBK��linuxʹ��UTF-8��������������
	 * <p>
	 * 2.font-family�������ã�����Ϊfont-family:SimSun;ע���Сд��������SIMSUN��simsun�����������ļ�����Ϊ�հ�
	 *
	 * @param data
	 * @param templateRoot
	 * @param htmlTemplateName
	 * @param fontPath
	 * @param charSet
	 * @param waterMarkPath
	 * @return
	 */
	public static OutputStream exportPdfByHtml(Map<String, Object> data, String templateRoot, String htmlTemplateName,
			String fontPath, String charSet, String waterMarkPath) {
		Assert.hasText(templateRoot, "ģ���Ŀ¼����Ϊ��");
		Assert.hasText(htmlTemplateName, "ģ�����ֲ���Ϊ��");
		Assert.hasText(fontPath, "�����ַ����Ϊ��");
		File file = new File(fontPath);
		Assert.isTrue(file.exists(), "ģ���ļ�������");
		Assert.hasText(charSet,"�ַ������벻��Ϊ��");
		return Html2Pdf.createPdf(data, templateRoot, htmlTemplateName, fontPath, charSet, waterMarkPath);
	}


	/**
	 * ͨ��HTMLģ������PDF(֧�ָ߼�CSS��ʽ���磺position)
	 * <p>
	 * htmlģ��ע�����
	 * <p>
	 * 1.charset�������ã�windows��ʹ��GBK��linuxʹ��UTF-8��������������
	 * <p>
	 * 2.font-family�������ã�����Ϊfont-family:SimSun;ע���Сд��������SIMSUN��simsun�����������ļ�����Ϊ�հ�
	 * <p>
	 * 3.img��ǩsrcʹ��fileЭ�飬�磺src="file:ͼƬ·��"/
	 *
	 * @param dataMap
	 * @param templateFileName
	 * @param templateInputStream
	 * @param fontPath
	 * @param charSet
	 * @param waterMarkPath
	 * @return
	 */
	public static OutputStream createPdfByHtml(Map<String, Object> dataMap, String templateFileName,
			InputStream templateInputStream, String fontPath, String charSet, String waterMarkPath) {

		File file = new File(fontPath);

		return Html2Pdf.createPdfByInputStream(dataMap, templateFileName, templateInputStream, fontPath, charSet,
				waterMarkPath);

	}

}
