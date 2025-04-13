import React, { useState } from 'react';
import PropTypes from 'prop-types';

const SelectField = ({ label, name, items }) => {
  const [selectedItem, setSelectedItem] = useState('');
  const [hasError, setHasError] = useState(false);

  const handleSelectChange = (event) => {
    const value = event.target.value;
    setSelectedItem(value);
    setHasError(value === ''); // Example logic for error
  };

  return (
    <form>
      <div className={`form-group ${!hasError ? '' : 'has-error'}`}>
        <label className="col-sm-2 control-label">{label}</label>
        <div className="col-sm-10">
          <select
            className="form-control"
            value={selectedItem}
            onChange={handleSelectChange}
          >
            {items.map((item, index) => (
              <option key={index} value={item}>
                {item}
              </option>
            ))}
          </select>
          {!hasError ? (
            <span className="fa fa-ok form-control-feedback" aria-hidden="true"></span>
          ) : (
            <div>
              <span className="fa fa-remove form-control-feedback" aria-hidden="true"></span>
              <span className="help-inline">Error</span>
            </div>
          )}
        </div>
      </div>
    </form>
  );
};

SelectField.propTypes = {
  label: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  items: PropTypes.arrayOf(PropTypes.string).isRequired,
};

export default SelectField;
