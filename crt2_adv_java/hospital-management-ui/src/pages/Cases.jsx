import { useState } from 'react';
import { mockCases } from '../data/mockData';
import { Power, CheckCircle, FileX } from 'lucide-react';

const Cases = () => {
  const [cases, setCases] = useState(mockCases);

  const getStatusBadge = (status) => {
    switch (status) {
      case 'Open': return 'badge-primary';
      case 'Operational': return 'badge-warning';
      case 'Closed': return 'badge-neutral';
      default: return 'badge-neutral';
    }
  };

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '2rem' }}>
        <h1 style={{ fontSize: '1.5rem', margin: 0 }}>Case Management</h1>
        <button className="btn btn-primary">Open New Case</button>
      </div>

      <div className="card">
        <div className="table-container" style={{ border: 'none', boxShadow: 'none' }}>
          <table>
            <thead>
              <tr>
                <th>Case ID</th>
                <th>Patient Ref</th>
                <th>Status</th>
                <th>Manage</th>
              </tr>
            </thead>
            <tbody>
              {cases.map(c => (
                <tr key={c.caseId}>
                  <td style={{ fontWeight: 500 }}>#{c.caseId}</td>
                  <td>Patient ID: {c.patientId}</td>
                  <td>
                    <span className={`badge ${getStatusBadge(c.status)}`}>
                      {c.status}
                    </span>
                  </td>
                  <td>
                    <div style={{ display: 'flex', gap: '0.5rem' }}>
                      <button 
                        className="btn btn-outline" 
                        style={{ padding: '0.25rem 0.5rem', fontSize: '0.75rem', borderColor: 'var(--primary-color)', color: 'var(--primary-color)' }}
                        disabled={c.status === 'Open'}
                      >
                        <Power size={14} /> Open
                      </button>
                      <button 
                        className="btn btn-outline" 
                        style={{ padding: '0.25rem 0.5rem', fontSize: '0.75rem', borderColor: 'var(--warning-color)', color: 'var(--warning-color)' }}
                        disabled={c.status === 'Operational'}
                      >
                        <CheckCircle size={14} /> Operate
                      </button>
                      <button 
                        className="btn btn-outline" 
                        style={{ padding: '0.25rem 0.5rem', fontSize: '0.75rem', borderColor: 'var(--text-secondary)', color: 'var(--text-secondary)' }}
                        disabled={c.status === 'Closed'}
                      >
                        <FileX size={14} /> Close
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Cases;
