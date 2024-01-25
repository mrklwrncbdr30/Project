import React, { useState, useEffect } from 'react';
import jsPDF from 'jspdf';
import img from '../assets/certificate-background.png';
import signatureImg from '../assets/Signiture.png';
import axios from 'axios';
import { saveAs } from 'file-saver';

// Add the toDataUrl function here
async function toDataUrl(url) {
  return new Promise((resolve, reject) => {
    const img = new Image();
    img.crossOrigin = 'Anonymous';
    img.onload = function () {
      const canvas = document.createElement('canvas');
      const ctx = canvas.getContext('2d');
      canvas.width = img.width;
      canvas.height = img.height;
      ctx.drawImage(img, 0, 0);
      resolve(canvas.toDataURL('image/png'));
    };
    img.onerror = reject;
    img.src = url;
  });
}

// Extracted CertificateDisplay as a functional component
const CertificateDisplay = ({ pdfUrl }) => {
  return (
    <div>
      <embed src={pdfUrl} type="application/pdf" width="100%" height="400px" style={{ border: 'none' }} />
    </div>
  );
};

function CertificateGenerator() {
  const [certificationData, setCertificationData] = useState([]);
  const [courseData, setCourseData] = useState([]);
  const [userData, setUserData] = useState([]);
  const [instructorData, setInstructorData] = useState([]);
  const [badgeData, setBadgeData] = useState([]);
  const [showCertificate, setShowCertificate] = useState(false);
  const [dataLoaded, setDataLoaded] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const certificationResult = await axios.get('http://localhost:8080/api/certifications/1');
        setCertificationData(certificationResult.data);

        const courseResult = await axios.get(`http://localhost:8080/api/courses/${certificationResult.data.courseId}`);
        setCourseData(courseResult.data);

        const usersResult = await axios.get(`http://localhost:8080/api/users/${certificationResult.data.userID}`);
        setUserData(usersResult.data);

        const instructorResult = await axios.get(`http://localhost:8080/api/instructors/${certificationResult.data.instructorID}`);
        setInstructorData(instructorResult.data);

        const badgeResult = await axios.get(`http://localhost:8080/api/badges/${certificationResult.data.badgeID}`);
        setBadgeData(badgeResult.data);

        setDataLoaded(true);
      } catch (error) {
        console.error('Error fetching certification data:', error);
      }
    };

    fetchData();
  }, []);

  async function generateCertificate() {
    try {
      if (!dataLoaded) {
        console.error('Data not loaded yet.');
        return;
      }

      const doc = new jsPDF({
        orientation: 'landscape',
        unit: 'mm',
        format: [297, 210],
      });

      doc.addImage(img, 'PNG', 0, 0, doc.internal.pageSize.getWidth(), doc.internal.pageSize.getHeight());
      doc.setTextColor(162, 123, 66);
      doc.setFont('helvetica');

      doc.setFontSize(35);
      doc.text(`${userData.full_name}`, 140, 108, { align: 'center' });

      // ... (rest of the code remains the same)

      // Save the PDF locally using FileSaver.js
      const pdfData = doc.output('blob');
      saveAs(pdfData, 'certificate.pdf');

      // Store the PDF in local storage
      const pdfBlob = new Blob([pdfData], { type: 'application/pdf' });
      const pdfUrl = URL.createObjectURL(pdfBlob);
      localStorage.setItem('generatedCertificate', pdfUrl);

      // Display the PDF using the new CertificateDisplay component
      setShowCertificate(pdfUrl);
    } catch (error) {
      console.error('Error generating certificate:', error);
    }
  }

  return (
    <div>
      <button onClick={generateCertificate}>Generate and Save Certificate</button>

      {/* Using the iframe (keep it for now) */}
      {showCertificate && (
        <div>
          <iframe title="Certificate" src={showCertificate} width="100%" height="400px" style={{ border: 'none' }} />
        </div>
      )}

      {/* Using the new CertificateDisplay component */}
      {showCertificate && <CertificateDisplay pdfUrl={showCertificate} />}
    </div>
  );
}

export default CertificateGenerator;
